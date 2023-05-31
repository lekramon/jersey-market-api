package com.tads.jerseymarketapi.models.enums;

public enum PaymentFormEnum {
    PIX(0),
    CREDIT(1),
    BOLETO(2);
    private final int payment;


    PaymentFormEnum(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }
}
