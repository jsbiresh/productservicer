package com.rafi.productservicer.services;

import com.rafi.productservicer.dtos.GenericProductDto;
import com.rafi.productservicer.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductServiceImpl implements ProductService {

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }
}
