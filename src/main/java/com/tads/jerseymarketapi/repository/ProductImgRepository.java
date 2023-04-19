package com.tads.jerseymarketapi.repository;

import com.tads.jerseymarketapi.models.ProductImgModel;
import com.tads.jerseymarketapi.models.ProductModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImgRepository extends JpaRepository<ProductImgModel, Id> {
    List<ProductImgModel> findByProductId(ProductModel productModel);
}
