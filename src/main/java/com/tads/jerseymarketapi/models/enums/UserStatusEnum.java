package com.tads.jerseymarketapi.models.enums;

public enum UserStatusEnum {
    INACTIVE(0),
    ACTIVE(1);
    private final int statusUserId;

    UserStatusEnum(int statusUserId) {
        this.statusUserId = statusUserId;
    }

    public int getStatusUserId() {
        return statusUserId;
    }
}
