package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ProductModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Id> {

}
