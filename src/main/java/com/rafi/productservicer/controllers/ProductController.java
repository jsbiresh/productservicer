package com.rafi.productservicer.controllers;

import com.rafi.productservicer.dtos.GenericProductDto;
import com.rafi.productservicer.models.Product;
import com.rafi.productservicer.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProducts() {
        return "Hola Mundos!";
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }


    @PostMapping("")
    public GenericProductDto createProduct(@RequestBody GenericProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    public void updateProductById() {

    }

    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }

}
