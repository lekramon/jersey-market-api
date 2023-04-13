package com.tads.jerseymarketapi.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_files")
public class ProductImgModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long filesId;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private String filename;
    @Column(nullable = false)
    private byte[] data;

    private String type;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductModel productModel;

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductModel getProduct() {
        return productModel;
    }

    public void setProduct(ProductModel productModel) {
        this.productModel = productModel;
    }
}
