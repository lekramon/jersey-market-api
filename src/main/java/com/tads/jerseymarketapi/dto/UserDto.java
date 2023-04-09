package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.UserGroupEnum;
import com.tads.jerseymarketapi.models.enums.UserStatusEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class UserDto {

    @NotBlank
    private String userName;
    @NotBlank
    @Email(message = "invalid e-mail")
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @CPF(message = "invalid cpf")
    private String cpf;
    @NotNull
    private UserGroupEnum userGroup;
    @NotNull
    private UserStatusEnum status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public UserGroupEnum getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEnum userGroup) {
        this.userGroup = userGroup;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

