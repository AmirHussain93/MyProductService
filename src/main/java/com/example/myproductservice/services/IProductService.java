package com.example.myproductservice.services;

import com.example.myproductservice.models.Product;

public interface IProductService {
    Product getProductById(Long id);
}
