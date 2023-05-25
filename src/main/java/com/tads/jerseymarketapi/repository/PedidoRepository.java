package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ClientModel;
import com.tads.jerseymarketapi.models.PedidoModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoModel, Id> {
     List<PedidoModel> findByClientId(ClientModel clientModel);

}
