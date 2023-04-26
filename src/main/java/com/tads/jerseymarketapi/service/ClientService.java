package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.ClientDto;
import com.tads.jerseymarketapi.dto.UpdateClientDto;
import com.tads.jerseymarketapi.models.ClientModel;
import com.tads.jerseymarketapi.models.enums.StatusEnum;
import com.tads.jerseymarketapi.repository.ClientRepository;
import com.tads.jerseymarketapi.service.factory.ClientFactory;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientModel register(ClientDto clientDto) {
        checkClientExistsByEmailToRegister(clientDto.getEmail());

        ClientFactory clientFactory = new ClientFactory();

        return clientRepository.save(clientFactory.createClientModel(clientDto));
    }

    public ClientModel login(String email, String password) {
        ClientModel clientModel = checkClientExistsByEmailToLogin(email);

        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);

        if (clientModel.getStatus() == StatusEnum.ACTIVE) {
            if (cryptographic.matches(password, clientModel.getPassword())) {
                return clientModel;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Client is not active, tell a admin.");
        }
    }

    @Transactional
    public ClientModel updateClientById(UpdateClientDto updateClientDto, long id) {
        ClientModel clientModel = checkClientExistsByIdToUpdate(id);

        updateClientIfNotBlankOrNull(updateClientDto, clientModel);

        return clientRepository.save(clientModel);
    }


    private void checkClientExistsByEmailToRegister(String email) {
        Optional<ClientModel> optionalClientModel = clientRepository.findByEmail(email);

        if (optionalClientModel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists. Please choose a different email.");
        }
    }

    private ClientModel checkClientExistsByEmailToLogin(String email) {
        Optional<ClientModel> optionalClientModel = clientRepository.findByEmail(email);

        if (optionalClientModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid e-mail, client not exists.");
        }

        return optionalClientModel.get();
    }

    private ClientModel checkClientExistsByIdToUpdate(long id) {
        Optional<ClientModel> clientModel = clientRepository.findById(id);

        if (clientModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found.");
        }

        return clientModel.get();
    }

    private void updateClientIfNotBlankOrNull(UpdateClientDto updateClientDto, ClientModel clientModel) {
        if (updateClientDto.getGender() != null) {
            clientModel.setGender(updateClientDto.getGender());
        }
        if (!StringUtils.isBlank(updateClientDto.getName())) {
            clientModel.setName(updateClientDto.getName());
        }
        if (!StringUtils.isBlank(updateClientDto.getDataNascimento())) {
            clientModel.setDataNascimento(updateClientDto.getDataNascimento());
        }
        if (!StringUtils.isBlank(updateClientDto.getPassword())) {
            BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
            String encodedPassword = cryptographic.encode(updateClientDto.getPassword());
            clientModel.setPassword(encodedPassword);
        }
    }
}
