package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.PedidoModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoModel, Id> {
     List<PedidoModel> findByClientId(Long clientModel);

     Optional<PedidoModel> findById(long id);
}
