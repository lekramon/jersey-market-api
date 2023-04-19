package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.LoginRequestDto;
import com.tads.jerseymarketapi.dto.UpdateUserBackofficeDto;
import com.tads.jerseymarketapi.dto.UserBackofficeDto;
import com.tads.jerseymarketapi.models.UserBackofficeModel;
import com.tads.jerseymarketapi.service.UserBackofficeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserBackofficeController {

    final UserBackofficeService userBackofficeService;

    public UserBackofficeController(UserBackofficeService userBackofficeService) {
        this.userBackofficeService = userBackofficeService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserBackofficeModel> saveUser(@RequestBody @Valid UserBackofficeDto userBackofficeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userBackofficeService.register(userBackofficeDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequestDto loginRequestDto) {
        UserBackofficeModel userBackofficeModel = userBackofficeService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Map<String, Object> response = new HashMap<>();
        response.put("name", userBackofficeModel.getName());
        response.put("email", userBackofficeModel.getEmail());
        response.put("id", userBackofficeModel.getId());
        response.put("userGroup", userBackofficeModel.getUserGroup());
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserBackofficeModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userBackofficeService.findAll());
    }

    @GetMapping("/list/admin")
    public ResponseEntity<List<UserBackofficeModel>> getAdminUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userBackofficeService.findAdmin());
    }

    @GetMapping("/list/storekeeper")
    public ResponseEntity<List<UserBackofficeModel>> getStorekeeperUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userBackofficeService.findStorekeeper());
    }


    @GetMapping("/id{id}")
    public ResponseEntity<Optional<UserBackofficeModel>> getUserById(@PathVariable(value = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userBackofficeService.findById(id));
    }

    @PutMapping("/id{id}/update")
    public ResponseEntity<Object> updateUserStatusById(@PathVariable(value = "id") long id, @RequestBody @Valid UpdateUserBackofficeDto updateUserBackofficeDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userBackofficeService.updateUserById(updateUserBackofficeDTO, id));
    }
}
