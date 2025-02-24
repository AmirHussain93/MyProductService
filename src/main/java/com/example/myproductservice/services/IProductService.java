package com.example.myproductservice.services;

import com.example.myproductservice.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Product product, Long id);
}
