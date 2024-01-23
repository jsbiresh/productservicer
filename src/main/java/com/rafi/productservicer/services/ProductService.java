package com.rafi.productservicer.services;

import com.rafi.productservicer.dtos.GenericProductDto;
import com.rafi.productservicer.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);
}
