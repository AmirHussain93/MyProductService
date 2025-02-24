package com.example.myproductservice.controllers;

import com.example.myproductservice.dtos.CategoryDto;
import com.example.myproductservice.dtos.ProductDto;
import com.example.myproductservice.models.Product;
import com.example.myproductservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/products/{id}")
    public ProductDto getProductDetails(@PathVariable Long id) {
        Product product = iProductService.getProductById(id);
        if(product == null) return null;
        return from(product);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        System.out.println("All Products:::"+ iProductService.getAllProducts());
        List<ProductDto> productDto = new ArrayList<>();
        List<Product> productList = iProductService.getAllProducts();

        for(Product product : productList) {
            productDto.add(from(product));
        }

        return productDto;
    }

    @PatchMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return null;
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
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

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        return  product;
    }
}
