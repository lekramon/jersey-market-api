package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.ClientGenderEnum;

public class UpdateClientDto {

    private String name;

    private String dataNascimento;

    private String password;

    private ClientGenderEnum gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientGenderEnum getGender() {
        return gender;
    }

    public void setGender(ClientGenderEnum gender) {
        this.gender = gender;
    }
}
