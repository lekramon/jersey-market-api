package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.ProductDto;
import com.tads.jerseymarketapi.models.ProductModel;
import com.tads.jerseymarketapi.service.ProductService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("product")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/register")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.register(productDto));
    }

}
