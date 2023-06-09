package com.tads.jerseymarketapi.models;

import com.tads.jerseymarketapi.models.enums.UserBackofficeGroupEnum;
import com.tads.jerseymarketapi.models.enums.StatusEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_user")
public class UserBackofficeModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 14)
    private String cpf;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserBackofficeGroupEnum userGroup;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status = StatusEnum.ACTIVE;


    public long getId() {
        return id;
    }

    public void setId(long idUser) {
        this.id = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBackofficeGroupEnum getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserBackofficeGroupEnum userGroup) {
        this.userGroup = userGroup;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
