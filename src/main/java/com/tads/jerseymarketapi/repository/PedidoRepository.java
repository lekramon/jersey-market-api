package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.PedidoModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Id> {
}
