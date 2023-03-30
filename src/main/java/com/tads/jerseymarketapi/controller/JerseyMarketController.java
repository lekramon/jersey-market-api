package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.service.UserService;
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

    final UserService userService;

    public JerseyMarketController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
        var jerseyMarketUserModel = new UserModel();
        BeanUtils.copyProperties(userDto, jerseyMarketUserModel);
        jerseyMarketUserModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(jerseyMarketUserModel));
    }
}
