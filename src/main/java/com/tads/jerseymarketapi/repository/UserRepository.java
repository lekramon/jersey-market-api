package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.UserModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Id> {

    Optional<UserModel> findByEmail(String email);
}
