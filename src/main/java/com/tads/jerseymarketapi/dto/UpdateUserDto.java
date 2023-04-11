package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.UserGroupEnum;
import com.tads.jerseymarketapi.models.enums.UserStatusEnum;

public class UpdateUserDto {

    private UserStatusEnum status;

    private String name;

    private UserGroupEnum userGroup;

    private String password;

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroupEnum getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEnum userGroup) {
        this.userGroup = userGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
