package com.tads.jerseymarketapi.dto;

import java.util.List;

public class PedidoResponseDto {
    private Long pedidoId;
    private Long clientId;
    private Long addressId;
    private double frete;
    private String pagamento;

    private String statusDelivery;

    private double valorTotal;

    private List<ItemPedidoDto> itensPedido;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemPedidoDto> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoDto> itensPedido) {
        this.itensPedido = itensPedido;
    }


    public String getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(String statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}