package com.tads.jerseymarketapi.controller;

import com.tads.jerseymarketapi.models.ProductImgModel;
import com.tads.jerseymarketapi.service.ProductImgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product/img")
public class ProductImgController {

    final ProductImgService productImgService;

    public ProductImgController(ProductImgService productImgService) {
        this.productImgService = productImgService;
    }

    @PostMapping("{id}/upload")
    public ResponseEntity<ProductImgModel> uploadProductImage(@PathVariable("id") long Id, @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(productImgService.save(file, Id));
    }
}
