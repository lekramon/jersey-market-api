package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.AtualizacaoStatusDto;
import com.tads.jerseymarketapi.dto.ItemPedidoDto;
import com.tads.jerseymarketapi.dto.PedidoDto;
import com.tads.jerseymarketapi.dto.PedidoResponseDto;
import com.tads.jerseymarketapi.models.PedidoItemModel;
import com.tads.jerseymarketapi.models.PedidoModel;
import com.tads.jerseymarketapi.repository.PedidoRepository;
import com.tads.jerseymarketapi.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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
        pedidoModel.setRegistrationDate(LocalDateTime.now());

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

    @GetMapping("/cliente/id{id}")
    public ResponseEntity<List<PedidoResponseDto>> getPedidosByClientId(@PathVariable("id") String clientId) {
        long clientIdAsLong;
        try {
            clientIdAsLong = Long.parseLong(clientId);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        List<PedidoModel> pedidos = pedidoRepository.findByClientId(clientIdAsLong);

        if (pedidos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<PedidoResponseDto> pedidosDto = new ArrayList<>();

        for (PedidoModel pedidoModel : pedidos) {
            PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();
            pedidoResponseDto.setPedidoId(pedidoModel.getId());
            pedidoResponseDto.setClientId(pedidoModel.getClientId());
            pedidoResponseDto.setAddressId(pedidoModel.getAddressId());
            pedidoResponseDto.setFrete(pedidoModel.getFrete());
            pedidoResponseDto.setPagamento(pedidoModel.getPaymentForm().toString());
            pedidoResponseDto.setStatusDelivery(pedidoModel.getDeliveryStatus().toString());
            pedidoResponseDto.setRegistrationDate(pedidoModel.getRegistrationDate());

            List<ItemPedidoDto> itensPedido = new ArrayList<>();
            double valorTotal = 0.0;

            for (PedidoItemModel item : pedidoModel.getItens()) {
                ItemPedidoDto itemPedidoDto = new ItemPedidoDto();
                itemPedidoDto.setProdutoId(item.getProdutoId());
                itemPedidoDto.setQuantidade(item.getQuantidade());
                itemPedidoDto.setPrecoUnitario(item.getPrecoUnitario());

                itensPedido.add(itemPedidoDto);
                valorTotal += item.getQuantidade() * item.getPrecoUnitario();
            }

            pedidoResponseDto.setItensPedido(itensPedido);
            pedidoResponseDto.setValorTotal(valorTotal);

            pedidosDto.add(pedidoResponseDto);
        }

        return ResponseEntity.ok(pedidosDto);
    }

    @PutMapping("/id{id}/update")
    public ResponseEntity<?> atualizarStatusEntrega(@PathVariable("id") Long id, @RequestBody AtualizacaoStatusDto atualizacaoStatusDto) {
        Optional<PedidoModel> optionalPedido = pedidoRepository.findById(id);

        if (optionalPedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PedidoModel pedido = optionalPedido.get();
        pedido.setDeliveryStatus(atualizacaoStatusDto.getStatus());

        pedidoRepository.save(pedido);

        return ResponseEntity.ok("Status de entrega atualizado com sucesso!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<PedidoResponseDto>> getAllPedidos() {
        List<PedidoModel> pedidos = pedidoRepository.findAll();

        if (pedidos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<PedidoResponseDto> pedidosDto = new ArrayList<>();

        for (PedidoModel pedidoModel : pedidos) {
            PedidoResponseDto pedidoDto = new PedidoResponseDto();
            pedidoDto.setPedidoId(pedidoModel.getId());
            pedidoDto.setClientId(pedidoModel.getClientId());
            pedidoDto.setAddressId(pedidoModel.getAddressId());
            pedidoDto.setFrete(pedidoModel.getFrete());
            pedidoDto.setPagamento(pedidoModel.getPaymentForm().toString());
            pedidoDto.setStatusDelivery(pedidoModel.getDeliveryStatus().toString());
            pedidoDto.setRegistrationDate(pedidoModel.getRegistrationDate());

            List<ItemPedidoDto> itensPedido = new ArrayList<>();
            double valorTotal = 0.0;

            for (PedidoItemModel item : pedidoModel.getItens()) {
                ItemPedidoDto itemPedidoDto = new ItemPedidoDto();
                itemPedidoDto.setProdutoId(item.getProdutoId());
                itemPedidoDto.setQuantidade(item.getQuantidade());
                itemPedidoDto.setPrecoUnitario(item.getPrecoUnitario());

                itensPedido.add(itemPedidoDto);
                valorTotal += item.getQuantidade() * item.getPrecoUnitario();
            }

            pedidoDto.setItensPedido(itensPedido);
            pedidoDto.setValorTotal(valorTotal);

            pedidosDto.add(pedidoDto);
        }

        return ResponseEntity.ok(pedidosDto);
    }

}
