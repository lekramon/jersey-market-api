package com.tads.jerseymarketapi.models;

import com.tads.jerseymarketapi.models.enums.ClientAddressEnum;
import com.tads.jerseymarketapi.models.enums.StatusEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_adress")
public class ClientAdressModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientModel clientId;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String localidade;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 100)
    private String complemento;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status = StatusEnum.ACTIVE;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ClientAddressEnum type;

    public ClientAdressModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClientModel getClientId() {
        return clientId;
    }

    public void setClientId(ClientModel clientId) {
        this.clientId = clientId;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public ClientAddressEnum getType() {
        return type;
    }

    public void setType(ClientAddressEnum type) {
        this.type = type;
    }
}
