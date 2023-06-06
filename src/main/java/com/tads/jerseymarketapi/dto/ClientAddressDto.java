package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.ClientAddressEnum;

public class ClientAddressDto {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    private String numero;

    private String complemento;

    private ClientAddressEnum type;


    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public ClientAddressEnum getType() {
        return type;
    }

}
