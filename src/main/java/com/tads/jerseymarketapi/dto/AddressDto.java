package com.tads.jerseymarketapi.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank
    private String cep;

    public String getCep() {
        return cep;
    }
}
