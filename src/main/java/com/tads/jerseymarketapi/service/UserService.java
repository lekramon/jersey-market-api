package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.UpdateUserDto;
import com.tads.jerseymarketapi.dto.UserDto;
import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.models.enums.UserGroupEnum;
import com.tads.jerseymarketapi.models.enums.UserStatusEnum;
import com.tads.jerseymarketapi.repository.UserRepository;
import com.tads.jerseymarketapi.service.factory.UserFactory;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel register(UserDto userDto) {
        checkUserExistsByEmailToRegister(userDto.getEmail());

        UserFactory userFactory = new UserFactory();

        return userRepository.save(userFactory.createUserModel(userDto));
    }

    public UserModel login(String email, String password) {
        UserModel userModel = checkUserExistsByEmailToLogin(email);

        BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);

        if (userModel.getStatus() == UserStatusEnum.ACTIVE) {
            if (cryptographic.matches(password, userModel.getPassword())) {
                return userModel;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is not active, tell a admin.");
        }
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

    public List<UserModel> findClient() {
        return userRepository.findByUserGroup(UserGroupEnum.CLIENT);
    }

    public Optional<UserModel> findById(long id) {
        return userRepository.findById(id);
    }


    @Transactional
    public UserModel updateUserById(UpdateUserDto updateUserDto, long id) {
        UserModel userModel = checkUserExistsByIdToUpdate(id);

        updateUserIfNotBlankOrNull(updateUserDto, userModel);

        return userRepository.save(userModel);
    }

    private void checkUserExistsByEmailToRegister(String email) {
        Optional<UserModel> optionalUserModel = userRepository.findByEmail(email);

        if (optionalUserModel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists. Please choose a different email.");
        }
    }

    private UserModel checkUserExistsByEmailToLogin(String email) {
        Optional<UserModel> optionalUserModel = userRepository.findByEmail(email);

        if (optionalUserModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid e-mail, user not exists.");
        }

        return optionalUserModel.get();
    }

    private UserModel checkUserExistsByIdToUpdate(long id) {
        Optional<UserModel> optionalUserModel = userRepository.findById(id);

        if (optionalUserModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }

        return optionalUserModel.get();
    }

    private void updateUserIfNotBlankOrNull(UpdateUserDto updateUserDto, UserModel userModel) {
        if (updateUserDto.getStatus() != null) {
            userModel.setStatus(updateUserDto.getStatus());
        }
        if (updateUserDto.getUserGroup() != null) {
            userModel.setUserGroup(updateUserDto.getUserGroup());
        }
        if (!StringUtils.isBlank(updateUserDto.getName())) {
            userModel.setName(updateUserDto.getName());
        }
        if (!StringUtils.isBlank(updateUserDto.getPassword())) {
            BCryptPasswordEncoder cryptographic = new BCryptPasswordEncoder(12);
            String encodedPassword = cryptographic.encode(updateUserDto.getPassword());
            userModel.setPassword(encodedPassword);
        }
        if (!StringUtils.isBlank(updateUserDto.getCpf())) {
            userModel.setCpf(updateUserDto.getCpf());
        }

    }
}
