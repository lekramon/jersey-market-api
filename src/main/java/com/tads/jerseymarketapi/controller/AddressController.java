package com.tads.jerseymarketapi.controller;


import com.tads.jerseymarketapi.dto.AddressDto;
import com.tads.jerseymarketapi.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("adress")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/find")
    public ResponseEntity findCep(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.find(addressDto));
    }
}
