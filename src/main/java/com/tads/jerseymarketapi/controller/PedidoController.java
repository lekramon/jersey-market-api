package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.ItemPedidoDto;
import com.tads.jerseymarketapi.dto.PedidoDto;
import com.tads.jerseymarketapi.models.PedidoItemModel;
import com.tads.jerseymarketapi.models.PedidoModel;
import com.tads.jerseymarketapi.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody PedidoDto pedidoDto) {
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setRegistrationDate(LocalDateTime.now());
        pedidoModel.setClientId(pedidoDto.getClientId());

        List<PedidoItemModel> itens = new ArrayList<>();

        for (ItemPedidoDto itemPedidoDto : pedidoDto.getItensPedido()) {
            PedidoItemModel pedidoItemModel = new PedidoItemModel();
            pedidoItemModel.setPedidoId(pedidoModel);
            pedidoItemModel.setProdutoId(itemPedidoDto.getProdutoId());
            pedidoItemModel.setQuantidade(itemPedidoDto.getQuantidade());
            pedidoItemModel.setPrecoUnitario(itemPedidoDto.getPrecoUnitario());

            itens.add(pedidoItemModel);
        }

        pedidoModel.setItens(itens);

        pedidoRepository.save(pedidoModel);

        return ResponseEntity.ok("Pedido criado com sucesso!");
    }
}
