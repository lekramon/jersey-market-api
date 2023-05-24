package com.tads.jerseymarketapi.dto;

import java.util.List;

public class PedidoDto {

    private List<ItemPedidoDto> itensPedido;

    private Long clientId;

    public List<ItemPedidoDto> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoDto> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
