package com.tads.jerseymarketapi.models.enums;

public enum StatusEnum {
    INACTIVE(0),
    ACTIVE(1);
    private final int statusUserId;

    StatusEnum(int statusUserId) {
        this.statusUserId = statusUserId;
    }

    public int getStatusUserId() {
        return statusUserId;
    }
}
