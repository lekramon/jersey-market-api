package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.dto.ProductDto;
import com.tads.jerseymarketapi.dto.UpdateProductDto;
import com.tads.jerseymarketapi.models.ProductModel;
import com.tads.jerseymarketapi.repository.ProductRepository;
import com.tads.jerseymarketapi.service.factory.ProductFactory;
import io.micrometer.common.util.StringUtils;
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
    public ProductModel updateUserById(UpdateProductDto updateProductDto, long id) {
        ProductModel productModel = checkProductExistsById(id);

        updateProductIfNotBlankOrNull(updateProductDto, productModel);

        return productRepository.save(productModel);
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    private ProductModel checkProductExistsById(long id) {
        Optional<ProductModel> optionalProductModel = productRepository.findById(id);

        if (optionalProductModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found.");
        }
        return optionalProductModel.get();
    }

    private void updateProductIfNotBlankOrNull(UpdateProductDto updateProductDto, ProductModel productModel) {
        if (updateProductDto.getStatus() != null) {
            productModel.setStatus(updateProductDto.getStatus());
        }
        if (updateProductDto.getQuantity() != null) {
            productModel.setQuantity(updateProductDto.getQuantity());
        }
        if (updateProductDto.getPrice() != null) {
            productModel.setPrice(updateProductDto.getPrice());
        }
        if (!StringUtils.isBlank(updateProductDto.getName())) {
            productModel.setName(updateProductDto.getName());
        }
        if (!StringUtils.isBlank(updateProductDto.getDescription())) {
            productModel.setDescription(updateProductDto.getDescription());
        }
    }


}
