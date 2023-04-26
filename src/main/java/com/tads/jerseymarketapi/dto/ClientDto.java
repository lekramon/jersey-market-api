package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.ClientGenderEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class ClientDto {

    @NotBlank
    private String name;
    @NotBlank
    @Email(message = "invalid e-mail")
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    @CPF(message = "invalid cpf")
    private String cpf;

    @NotBlank
    private String dataNascimento;

    @NotNull
    private ClientGenderEnum gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ClientGenderEnum getGender() {
        return gender;
    }

    public void setGender(ClientGenderEnum gender) {
        this.gender = gender;
    }
}

