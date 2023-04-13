package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.dto.ProductDto;
import com.tads.jerseymarketapi.dto.UpdateProductDto;
import com.tads.jerseymarketapi.models.ProductModel;
import com.tads.jerseymarketapi.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/list")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @PutMapping("/id{id}/update")
    public ResponseEntity<Object> updateProductById(@PathVariable(value = "id") long id, @RequestBody @Valid UpdateProductDto updateProductDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateUserById(updateProductDto, id));
    }

}
