package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.models.ProductImgModel;
import com.tads.jerseymarketapi.models.ProductModel;
import com.tads.jerseymarketapi.repository.ProductImgRepository;
import com.tads.jerseymarketapi.repository.ProductRepository;
import com.tads.jerseymarketapi.service.factory.ProductImgFactory;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProductImgService {

    final ProductImgRepository productImgRepository;
    final ProductRepository productRepository;

    public ProductImgService(ProductImgRepository productImgRepository, ProductRepository productRepository) {
        this.productImgRepository = productImgRepository;
        this.productRepository = productRepository;
    }
@Transactional
    public ProductImgModel save(MultipartFile file, long id) throws IOException {
        return uploadFile(file, id);
    }


    private ProductImgModel uploadFile(MultipartFile files, long id) throws IOException {
        byte[] data = files.getBytes();
        String type = files.getContentType();
        String filename = files.getOriginalFilename();
        validateFilename(filename);

        ProductModel productModel = checkProductExistsById(id);

        ProductImgFactory productImgFactory = new ProductImgFactory();

        return productImgRepository.save(productImgFactory.createProductImgModel(filename, data, type, productModel));
    }

    private ProductModel checkProductExistsById(long id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid product, this product exists?");
        }
        return productModel.get();
    }

    private static void validateFilename(String filename) {
        if (filename != null) {
            if (filename.contains("..")) {
                throw new RuntimeException("Filename contains invalid path [" + filename + "]");
            }
        } else {
            throw new IllegalArgumentException("Filename cannot be null.");
        }
    }
}
