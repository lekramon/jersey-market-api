package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ClientModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientModel, Id> {

    Optional<ClientModel> findByEmail(String email);

    Optional<ClientModel> findById(long id);
}
