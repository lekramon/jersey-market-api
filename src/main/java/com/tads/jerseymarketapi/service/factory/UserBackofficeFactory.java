package com.tads.jerseymarketapi.service.factory;

import com.tads.jerseymarketapi.dto.UserBackofficeDto;
import com.tads.jerseymarketapi.models.UserBackofficeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserBackofficeFactory {

    public UserBackofficeModel createUserModel(UserBackofficeDto userBackofficeDto) {
        UserBackofficeModel userBackofficeModel = new UserBackofficeModel();
        BeanUtils.copyProperties(userBackofficeDto, userBackofficeModel);
        userBackofficeModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
        String encodedPassword = cryptographic.encode(userBackofficeModel.getPassword());
        userBackofficeModel.setPassword(encodedPassword);
        return userBackofficeModel;
    }

}
