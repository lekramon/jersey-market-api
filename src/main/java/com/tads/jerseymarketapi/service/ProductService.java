package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.ProductDto;
import com.tads.jerseymarketapi.models.ProductModel;
import com.tads.jerseymarketapi.repository.ProductRepository;
import com.tads.jerseymarketapi.service.factory.ProductFactory;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void deleteById(Long id) {
        checkProductExistsById(id);
        productRepository.deleteById(id);
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    private void checkProductExistsById(long id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid product, this product exists?");
        }
    }


}
