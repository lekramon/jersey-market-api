package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.UserModel;
import com.tads.jerseymarketapi.models.enums.UserGroupEnum;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Id> {

    Optional<UserModel> findByEmail(String email);

    List<UserModel> findByUserGroup(UserGroupEnum groupEnum);

    Optional<UserModel> findById(Long id);
}
