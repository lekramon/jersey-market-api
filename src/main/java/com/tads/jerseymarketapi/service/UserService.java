package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.models.enums.UserStatusEnum;
import com.tads.jerseymarketapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
            }
        }
        return null;
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }


}
