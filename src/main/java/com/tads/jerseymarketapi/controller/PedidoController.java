package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.ItemPedidoDto;
import com.tads.jerseymarketapi.dto.PedidoDto;
import com.tads.jerseymarketapi.models.PedidoItemModel;
import com.tads.jerseymarketapi.models.PedidoModel;
import com.tads.jerseymarketapi.repository.PedidoRepository;
import com.tads.jerseymarketapi.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    final PedidoRepository pedidoRepository;
    final PedidoService pedidoService;

    public PedidoController(PedidoRepository pedidoRepository, PedidoService pedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody PedidoDto pedidoDto) {
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setRegistrationDate(LocalDateTime.now());
        pedidoModel.setClientId(pedidoDto.getClientId());
        pedidoModel.setFrete(pedidoDto.getFrete());
        pedidoModel.setPaymentForm(pedidoDto.getPagamento());
        pedidoModel.setAddressId(pedidoDto.getAddressId());

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

    @GetMapping("/id{id}")
    public ResponseEntity<List<PedidoModel>> getPedido(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findPedidoByClientId(id));
    }
}
