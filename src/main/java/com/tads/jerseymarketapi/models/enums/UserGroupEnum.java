package com.tads.jerseymarketapi.models.enums;

public enum UserGroupEnum {
    ADMIN(1),
    STOREKEEPER(2);

    private final int userGroupId;

    UserGroupEnum(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public int getUserGroupId() {
        return userGroupId;
    }
}
