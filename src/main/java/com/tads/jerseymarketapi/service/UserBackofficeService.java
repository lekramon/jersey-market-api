package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.UpdateUserBackofficeDto;
import com.tads.jerseymarketapi.dto.UserBackofficeDto;
import com.tads.jerseymarketapi.models.UserBackofficeModel;
import com.tads.jerseymarketapi.models.enums.StatusEnum;
import com.tads.jerseymarketapi.models.enums.UserBackofficeGroupEnum;
import com.tads.jerseymarketapi.repository.UserBackofficeRepository;
import com.tads.jerseymarketapi.service.factory.UserBackofficeFactory;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserBackofficeService {

    final UserBackofficeRepository userBackofficeRepository;

    public UserBackofficeService(UserBackofficeRepository userBackofficeRepository) {
        this.userBackofficeRepository = userBackofficeRepository;
    }

    @Transactional
    public UserBackofficeModel register(UserBackofficeDto userBackofficeDto) {
        checkUserExistsByEmailToRegister(userBackofficeDto.getEmail());

        UserBackofficeFactory userBackofficeFactory = new UserBackofficeFactory();

        return userBackofficeRepository.save(userBackofficeFactory.createUserModel(userBackofficeDto));
    }

    public UserBackofficeModel login(String email, String password) {
        UserBackofficeModel userBackofficeModel = checkUserExistsByEmailToLogin(email);

        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);

        if (userBackofficeModel.getStatus() == StatusEnum.ACTIVE) {
            if (cryptographic.matches(password, userBackofficeModel.getPassword())) {
                return userBackofficeModel;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is not active, tell a admin.");
        }
    }

    public List<UserBackofficeModel> findAll() {
        return userBackofficeRepository.findAll();
    }

    public List<UserBackofficeModel> findAdmin() {
        return userBackofficeRepository.findByUserGroup(UserBackofficeGroupEnum.ADMIN);
    }

    public List<UserBackofficeModel> findStorekeeper() {
        return userBackofficeRepository.findByUserGroup(UserBackofficeGroupEnum.STOREKEEPER);
    }


    public Optional<UserBackofficeModel> findById(long id) {
        return userBackofficeRepository.findById(id);
    }


    @Transactional
    public UserBackofficeModel updateUserById(UpdateUserBackofficeDto updateUserBackofficeDto, long id) {
        UserBackofficeModel userBackofficeModel = checkUserExistsByIdToUpdate(id);

        updateUserIfNotBlankOrNull(updateUserBackofficeDto, userBackofficeModel);

        return userBackofficeRepository.save(userBackofficeModel);
    }

    private void checkUserExistsByEmailToRegister(String email) {
        Optional<UserBackofficeModel> optionalUserModel = userBackofficeRepository.findByEmail(email);

        if (optionalUserModel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists. Please choose a different email.");
        }
    }

    private UserBackofficeModel checkUserExistsByEmailToLogin(String email) {
        Optional<UserBackofficeModel> optionalUserModel = userBackofficeRepository.findByEmail(email);

        if (optionalUserModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid e-mail, user not exists.");
        }

        return optionalUserModel.get();
    }

    private UserBackofficeModel checkUserExistsByIdToUpdate(long id) {
        Optional<UserBackofficeModel> optionalUserModel = userBackofficeRepository.findById(id);

        if (optionalUserModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }

        return optionalUserModel.get();
    }

    private void updateUserIfNotBlankOrNull(UpdateUserBackofficeDto updateUserBackofficeDto, UserBackofficeModel userBackofficeModel) {
        if (updateUserBackofficeDto.getStatus() != null) {
            userBackofficeModel.setStatus(updateUserBackofficeDto.getStatus());
        }
        if (updateUserBackofficeDto.getUserGroup() != null) {
            userBackofficeModel.setUserGroup(updateUserBackofficeDto.getUserGroup());
        }
        if (!StringUtils.isBlank(updateUserBackofficeDto.getName())) {
            userBackofficeModel.setName(updateUserBackofficeDto.getName());
        }
        if (!StringUtils.isBlank(updateUserBackofficeDto.getPassword())) {
            BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
            String encodedPassword = cryptographic.encode(updateUserBackofficeDto.getPassword());
            userBackofficeModel.setPassword(encodedPassword);
        }
        if (!StringUtils.isBlank(updateUserBackofficeDto.getCpf())) {
            userBackofficeModel.setCpf(updateUserBackofficeDto.getCpf());
        }
    }
}
