package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.JerseyMarketUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JerseyMarketRepository extends JpaRepository<JerseyMarketUserModel, UUID> {
}
