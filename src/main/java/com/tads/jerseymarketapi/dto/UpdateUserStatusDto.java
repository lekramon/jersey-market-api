package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.UserStatusEnum;
import jakarta.validation.constraints.NotNull;

public class UpdateUserStatusDto {

    @NotNull
    private UserStatusEnum status;

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }
}
