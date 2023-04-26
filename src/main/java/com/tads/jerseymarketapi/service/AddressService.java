package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.config.AddressFeign;
import com.tads.jerseymarketapi.dto.AddressResponse;
import com.tads.jerseymarketapi.dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressFeign addressFeign;

    public AddressService(AddressFeign addressFeign) {
        this.addressFeign = addressFeign;
    }

    public AddressResponse find(AddressDto addressDto) {
        return addressFeign.findAdressByCep(addressDto.getCep());
    }
}
