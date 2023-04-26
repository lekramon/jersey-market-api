package com.tads.jerseymarketapi.models.enums;

public enum StatusEnum {
    INACTIVE(0),
    ACTIVE(1);
    private final int status;

    StatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
