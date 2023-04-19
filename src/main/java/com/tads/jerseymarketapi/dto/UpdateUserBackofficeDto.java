package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.UserBackofficeGroupEnum;
import com.tads.jerseymarketapi.models.enums.StatusEnum;
import org.hibernate.validator.constraints.br.CPF;

public class UpdateUserBackofficeDto {

    private StatusEnum status;

    private String name;

    private UserBackofficeGroupEnum userGroup;

    private String password;

    @CPF(message = "invalid cpf")
    private String cpf;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserBackofficeGroupEnum getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserBackofficeGroupEnum userGroup) {
        this.userGroup = userGroup;
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
}
