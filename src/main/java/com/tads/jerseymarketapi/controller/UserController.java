package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.LoginRequestDto;
import com.tads.jerseymarketapi.dto.UpdateUserDto;
import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.service.UserService;
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
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequestDto loginRequestDto) {
        UserModel userModel = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Map<String, Object> response = new HashMap<>();
        response.put("name", userModel.getName());
        response.put("email", userModel.getEmail());
        response.put("id", userModel.getId());
        response.put("userGroup", userModel.getUserGroup());
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserModel>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/list/admin")
    public ResponseEntity<List<UserModel>> getAdminUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAdmin());
    }

    @GetMapping("/list/storekeeper")
    public ResponseEntity<List<UserModel>> getStorekeeperUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findStorekeeper());
    }

    @GetMapping("/list/client")
    public ResponseEntity<List<UserModel>> getClient() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findClient());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<UserModel>> getUserById(@PathVariable(value = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PutMapping("/id/{id}/update")
    public ResponseEntity<Object> updateUserStatusById(@PathVariable(value = "id") long id, @RequestBody @Valid UpdateUserDto updateUserDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(updateUserDTO, id));
    }
}
