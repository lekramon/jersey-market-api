package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.ClientAddressDto;
import com.tads.jerseymarketapi.models.ClientAdressModel;
import com.tads.jerseymarketapi.service.ClientAddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client/address")
public class ClientAddressController {

    final ClientAddressService clientAddressService;

    public ClientAddressController(ClientAddressService clientAddressService) {
        this.clientAddressService = clientAddressService;
    }

    @PostMapping("id{id}/register")
    public ResponseEntity<ClientAdressModel> registerAddress(@PathVariable("id") long id, @RequestBody @Valid ClientAddressDto clientAddressDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientAddressService.registerAddress(clientAddressDto, id));
    }
}
