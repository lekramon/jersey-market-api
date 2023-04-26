package com.tads.jerseymarketapi.service.factory;

import com.tads.jerseymarketapi.dto.ClientAddressDto;
import com.tads.jerseymarketapi.models.ClientAdressModel;
import com.tads.jerseymarketapi.models.ClientModel;
import org.springframework.beans.BeanUtils;

public class ClientAddressFactory {

    public ClientAdressModel createClientAddressModel(ClientAddressDto clientAddressDto, ClientModel client) {
        ClientAdressModel clientAdressModel = new ClientAdressModel();
        clientAdressModel.setClientId(client);
        BeanUtils.copyProperties(clientAddressDto, clientAdressModel);
        return clientAdressModel;
    }

}
