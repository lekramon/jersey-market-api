package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.models.enums.UserGroupEnum;
import com.tads.jerseymarketapi.models.enums.UserStatusEnum;
import com.tads.jerseymarketapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserDto userDto) {
        Optional<UserModel> optionalUserModel = userRepository.findByEmail(userDto.getEmail());
        if (optionalUserModel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists. Please choose a different email.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
        String encodedPassword = cryptographic.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        userModel.setStatus(UserStatusEnum.ACTIVE);
        return userRepository.save(userModel);
    }

    public UserModel login(String email, String password) {
        Optional<UserModel> optionalUserModel = userRepository.findByEmail(email);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
            if (cryptographic.matches(password, userModel.getPassword())) {
                return userModel;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid e-mail or password.");
            }
        }
        return null;
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public List<UserModel> findAdmin() {
        return userRepository.findByUserGroup(UserGroupEnum.ADMIN);
    }

    public List<UserModel> findStorekeeper() {
        return userRepository.findByUserGroup(UserGroupEnum.STOREKEEPER);
    }

    @Transactional
    public UserModel updateUserStatusById(Long id, UserStatusEnum status) {
        Optional<UserModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        UserModel userModel = optionalUserModel.get();
        userModel.setStatus(status);
        return userRepository.save(userModel);
    }

}
