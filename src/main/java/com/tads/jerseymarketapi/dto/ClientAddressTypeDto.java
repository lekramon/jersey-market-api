package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.ClientAddressEnum;

public class ClientAddressTypeDto {

    private ClientAddressEnum type;

    public ClientAddressEnum getType() {
        return type;
    }

    public void setType(ClientAddressEnum type) {
        this.type = type;
    }
}