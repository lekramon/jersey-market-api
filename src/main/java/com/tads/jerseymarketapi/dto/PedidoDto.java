package com.tads.jerseymarketapi.dto;

import com.tads.jerseymarketapi.models.enums.PaymentFormEnum;

import java.util.List;

public class PedidoDto {

    private List<ItemPedidoDto> itensPedido;

    private Long clientId;

    private Long addressId;

    private double frete;

    private PaymentFormEnum pagamento;

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

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public PaymentFormEnum getPagamento() {
        return pagamento;
    }

    public void setPagamento(PaymentFormEnum pagamento) {
        this.pagamento = pagamento;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
