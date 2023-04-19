package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.UserBackofficeModel;
import com.tads.jerseymarketapi.models.enums.UserBackofficeGroupEnum;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserBackofficeRepository extends JpaRepository<UserBackofficeModel, Id> {

    Optional<UserBackofficeModel> findByEmail(String email);

    List<UserBackofficeModel> findByUserGroup(UserBackofficeGroupEnum groupEnum);

    Optional<UserBackofficeModel> findById(Long id);
}
