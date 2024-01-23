package com.rafi.productservicer.dtos;

import com.rafi.productservicer.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}