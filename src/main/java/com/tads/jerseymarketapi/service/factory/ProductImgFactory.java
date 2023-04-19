package com.tads.jerseymarketapi.service.factory;

import com.tads.jerseymarketapi.models.ProductImgModel;
import com.tads.jerseymarketapi.models.ProductModel;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ProductImgFactory {

    public ProductImgModel createProductImgModel(String filename, byte[] data, String type, ProductModel product) {
        ProductImgModel productImgModel = new ProductImgModel();
        productImgModel.setFilename(filename);
        productImgModel.setData(data);
        productImgModel.setType(type);
        productImgModel.setProduct(product);
        productImgModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return productImgModel;
    }
}
