package com.tads.jerseymarketapi.service.factory;

import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserFactory {

    public UserModel createUserModel(UserDto userDto) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
        String encodedPassword = cryptographic.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        return userModel;
    }

}
