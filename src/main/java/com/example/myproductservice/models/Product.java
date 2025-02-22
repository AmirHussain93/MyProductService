package com.example.myproductservice.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends  BaseModel {
    private String name;
    private String description;
    private Category category;
    private double price;
    private boolean isPrime;
    private String imageUrl;
}
