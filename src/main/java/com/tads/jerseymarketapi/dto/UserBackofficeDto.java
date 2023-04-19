package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.UserBackofficeGroupEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class UserBackofficeDto {

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
    @NotNull
    private UserBackofficeGroupEnum userGroup;

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

    public UserBackofficeGroupEnum getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserBackofficeGroupEnum userGroup) {
        this.userGroup = userGroup;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

