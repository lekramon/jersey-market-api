package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.LoginRequestDto;
import com.tads.jerseymarketapi.dto.UpdateUserStatusDto;
import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.repository.UserRepository;
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
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto) {
        UserModel userModel = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (userModel != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("userGroup", userModel.getUserGroup());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
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

    @PutMapping("/{id}/status")
    public ResponseEntity<Object> updateUserStatusById(@PathVariable(value = "id") long id,
                                                       @RequestBody @Valid UpdateUserStatusDto updateUserStatusDTO) {
        Optional<UserModel> userModelOpt = userService.findById(id);
        if (userModelOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        UserModel userModel = userModelOpt.get();
        userModel.setStatus(updateUserStatusDTO.getStatus());
        UserModel updatedUserModel = userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUserModel);
    }

}
