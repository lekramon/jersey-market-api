package com.tads.jerseymarketapi.models.enums;

public enum UserGroupEnum {
    ADMIN(0),
    STOREKEEPER(1),
    CLIENT(2);

    private final int userGroupId;

    UserGroupEnum(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public int getUserGroupId() {
        return userGroupId;
    }
}
