package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.models.ClientModel;
import com.tads.jerseymarketapi.models.PedidoModel;
import com.tads.jerseymarketapi.repository.ClientRepository;
import com.tads.jerseymarketapi.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final ClientRepository clientRepository;
    private final PedidoRepository pedidoRepository;

    public PedidoService(ClientRepository clientRepository, PedidoRepository pedidoRepository) {
        this.clientRepository = clientRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoModel> findPedidoByClientId(long id) {
        ClientModel clientModel = checkClientExistsById(id);
        return pedidoRepository.findByClientId(clientModel);
    }

    private ClientModel checkClientExistsById(long id) {
        Optional<ClientModel> clientModel = clientRepository.findById(id);
        if (clientModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client, this client exists?");
        }
        return clientModel.get();
    }
}
