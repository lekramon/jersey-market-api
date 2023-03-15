package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.models.JerseyMarketUserModel;
import com.tads.jerseymarketapi.service.JerseyMarketService;
import dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/jersey-market")
public class JerseyMarketController {

    final JerseyMarketService jerseyMarketService;

    public JerseyMarketController(JerseyMarketService jerseyMarketService) {
        this.jerseyMarketService = jerseyMarketService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
        var jerseyMarketUserModel = new JerseyMarketUserModel();
        BeanUtils.copyProperties(userDto, jerseyMarketUserModel);
        jerseyMarketUserModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(jerseyMarketService.save(jerseyMarketUserModel));
    }
}
