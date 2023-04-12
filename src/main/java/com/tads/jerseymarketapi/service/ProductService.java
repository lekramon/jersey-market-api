package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.ProductDto;
import com.tads.jerseymarketapi.models.ProductModel;
import com.tads.jerseymarketapi.repository.ProductRepository;
import com.tads.jerseymarketapi.service.factory.ProductFactory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductModel register(ProductDto productDto) {

        ProductFactory productFactory = new ProductFactory();

        return productRepository.save(productFactory.createProductModel(productDto));

    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }


}
