package com.tads.jerseymarketapi.models.enums;

public enum ClientAddressEnum {
    DEFAULT(0),
    DELIVERY(1),
    BILLING(2);
    private final int addressType;

    ClientAddressEnum(int addressType) {
        this.addressType = addressType;
    }

    public int getAddressType() {
        return addressType;
    }
}
