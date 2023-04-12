package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ProductImgModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImgRepository extends JpaRepository<ProductImgModel, Id> {
}
