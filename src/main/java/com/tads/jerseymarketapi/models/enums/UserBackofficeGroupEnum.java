package com.tads.jerseymarketapi.models.enums;

public enum UserBackofficeGroupEnum {
    EMPTY(0),
    ADMIN(1),
    STOREKEEPER(2);

    private final int userGroupId;

    UserBackofficeGroupEnum(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public int getUserGroupId() {
        return userGroupId;
    }
}
