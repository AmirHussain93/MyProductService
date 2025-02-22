package com.example.myproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    Long id;
    String title;
    String description;
    double price;
    String category;
    String image;
}
