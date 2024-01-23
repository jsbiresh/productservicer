package com.rafi.productservicer.services;

import com.rafi.productservicer.dtos.FakeStoreProductDto;
import com.rafi.productservicer.dtos.GenericProductDto;
import com.rafi.productservicer.models.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
//        FakeStoreProductDto product = restTemplate.getForObject("https://fakestoreapi.com/products/1", FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }

    public GenericProductDto createProduct(GenericProductDto product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product, GenericProductDto.class);

        return response.getBody();


//        RestTemplate restTemplate = restTemplateBuilder.build();
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        BeanUtils.copyProperties(product, fakeStoreProductDto);
//        return product;
    }
}
