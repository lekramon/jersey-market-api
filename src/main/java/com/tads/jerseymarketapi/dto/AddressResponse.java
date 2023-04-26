package com.tads.jerseymarketapi.dto;

public class AddressResponse {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

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
}
