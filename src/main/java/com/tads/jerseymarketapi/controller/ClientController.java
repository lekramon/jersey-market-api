package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.ClientDto;
import com.tads.jerseymarketapi.dto.LoginRequestDto;
import com.tads.jerseymarketapi.dto.UpdateClientDto;
import com.tads.jerseymarketapi.models.ClientModel;
import com.tads.jerseymarketapi.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/register")
    public ResponseEntity<ClientModel> saveUser(@RequestBody @Valid ClientDto clientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.register(clientDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequestDto loginRequestDto) {
        ClientModel clientModel = clientService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Map<String, Object> response = new HashMap<>();
        response.put("name", clientModel.getName());
        response.put("email", clientModel.getEmail());
        response.put("id", clientModel.getId());
        response.put("cpf", clientModel.getCpf());
        response.put("date", clientModel.getDataNascimento());
        response.put("gender", clientModel.getGender());
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/id{id}/update")
    public ResponseEntity<Object> updateClientById(@PathVariable(value = "id") long id, @RequestBody @Valid UpdateClientDto updateClientDto) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClientById(updateClientDto, id));
    }
}
