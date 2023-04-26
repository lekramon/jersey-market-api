package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ClientAdressModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAddressRepository extends JpaRepository<ClientAdressModel, Id> {
}
