package com.example.myproductservice.controllers;

import com.example.myproductservice.dtos.CategoryDto;
import com.example.myproductservice.dtos.ProductDto;
import com.example.myproductservice.models.Product;
import com.example.myproductservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/products/{id}")
    public ProductDto getProductDetails(@PathVariable Long id) {
        Product product = iProductService.getProductById(id);
        System.out.println("Product details:::"+ product);
        if(product == null) return null;
        return from(product);
    }

    @GetMapping("/products")
    public ProductDto getAllProducts() {
        return null;
    }

    @PatchMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return null;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {

    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return null;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getCategoryName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }
}
