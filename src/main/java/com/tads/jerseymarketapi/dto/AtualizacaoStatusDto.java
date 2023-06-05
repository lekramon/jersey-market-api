package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.DeliveryStatusEnum;

public class AtualizacaoStatusDto {
    private DeliveryStatusEnum status;

    public DeliveryStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatusEnum status) {
        this.status = status;
    }
}
