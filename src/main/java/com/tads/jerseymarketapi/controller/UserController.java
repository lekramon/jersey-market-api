package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.LoginRequest;
import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        UserModel userModel = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (userModel != null) {
            String login = "Successfully login!";
            return ResponseEntity.ok(login);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid e-mail or password");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserModel>> getAllUserModels() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }


}
