package com.tads.jerseymarketapi.service.factory;

import com.tads.jerseymarketapi.dto.ProductDto;
import com.tads.jerseymarketapi.models.ProductModel;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ProductFactory {

    public ProductModel createProductModel(ProductDto productDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDto, productModel);
        productModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return productModel;
    }
}
