package com.tads.jerseymarketapi.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
public class PedidoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Long clientId;

    @OneToMany(mappedBy = "pedidoId", cascade = CascadeType.ALL)
    private List<PedidoItemModel> itens;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


    public List<PedidoItemModel> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItemModel> itens) {
        this.itens = itens;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
