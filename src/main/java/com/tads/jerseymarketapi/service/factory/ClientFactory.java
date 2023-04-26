package com.tads.jerseymarketapi.service.factory;

import com.tads.jerseymarketapi.dto.ClientDto;
import com.tads.jerseymarketapi.models.ClientModel;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClientFactory {

    public ClientModel createClientModel(ClientDto clientDto) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);
        clientModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
        String encodedPassword = cryptographic.encode(clientModel.getPassword());
        clientModel.setPassword(encodedPassword);
        return clientModel;
    }

}
