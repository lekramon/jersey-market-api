package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.ClientAddressDto;
import com.tads.jerseymarketapi.dto.ClientAddressTypeDto;
import com.tads.jerseymarketapi.models.ClientAdressModel;
import com.tads.jerseymarketapi.models.ClientModel;
import com.tads.jerseymarketapi.repository.ClientAddressRepository;
import com.tads.jerseymarketapi.repository.ClientRepository;
import com.tads.jerseymarketapi.service.factory.ClientAddressFactory;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientAddressService {

    final ClientAddressRepository clientAddressRepository;
    final ClientRepository clientRepository;

    public ClientAddressService(ClientAddressRepository clientAddressRepository, ClientRepository clientRepository) {
        this.clientAddressRepository = clientAddressRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientAdressModel registerAddress(ClientAddressDto clientAddressDto, long id) {
        return saveAddress(clientAddressDto, id);
    }

    public List<ClientAdressModel> findAddressByClientId(long id) {
        ClientModel clientModel = checkClientExistsById(id);
        return clientAddressRepository.findByClientId(clientModel);
    }

    @Transactional
    public ClientAdressModel updateAddressType(long addressId, ClientAddressTypeDto clientAddressTypeDto) {
        ClientAdressModel addressModel = getAddressById(addressId);

        addressModel.setType(clientAddressTypeDto.getType());

        return clientAddressRepository.save(addressModel);
    }

    private ClientAdressModel getAddressById(long addressId) {
        Optional<ClientAdressModel> addressModelOptional = clientAddressRepository.findById(addressId);
        if (addressModelOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
        return addressModelOptional.get();
    }

    private ClientAdressModel saveAddress(ClientAddressDto clientAddressDto, long id) {
        ClientModel clientModel = checkClientExistsById(id);

        ClientAddressFactory clientAddressFactory = new ClientAddressFactory();

        return clientAddressRepository.save(clientAddressFactory.createClientAddressModel(clientAddressDto, clientModel));
    }


    private ClientModel checkClientExistsById(long id) {
        Optional<ClientModel> clientModel = clientRepository.findById(id);
        if (clientModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        return clientModel.get();
    }

}
