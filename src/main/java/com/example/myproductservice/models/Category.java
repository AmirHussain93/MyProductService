package com.example.myproductservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Category extends BaseModel {
    String categoryName;
    String description;
    List<Product> products;
}
