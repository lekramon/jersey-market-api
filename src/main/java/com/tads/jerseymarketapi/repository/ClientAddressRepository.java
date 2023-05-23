package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ClientAdressModel;
import com.tads.jerseymarketapi.models.ClientModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientAddressRepository extends JpaRepository<ClientAdressModel, Id> {
    List<ClientAdressModel> findByClientId(ClientModel clientModel);
}
