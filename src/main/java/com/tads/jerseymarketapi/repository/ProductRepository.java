package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ProductModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Id> {

    Optional<ProductModel> findById(long id);

    ProductModel deleteProductModelById(long id);

    void deleteById(Long id);
}
