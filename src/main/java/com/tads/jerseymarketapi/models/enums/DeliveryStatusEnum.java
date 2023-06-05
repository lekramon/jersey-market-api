package com.tads.jerseymarketapi.models.enums;

public enum DeliveryStatusEnum {
    PREPARATION(0),
    DELIVERY(1),
    DELIVERED(2);

    private final int delivery;

    DeliveryStatusEnum(int delivery) {
        this.delivery = delivery;
    }

    public int getDelivery() {
        return delivery;
    }
}
