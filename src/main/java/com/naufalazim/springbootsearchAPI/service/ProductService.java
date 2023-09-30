package com.naufalazim.springbootsearchAPI.service;

import com.naufalazim.springbootsearchAPI.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProducts(String query); //Search
    Product createdProduct(Product product);    //Created
    List<Product> getAllProducts();   // Get All list
    Product updateProduct(Long id, Product updatedProduct); // Update
    void deleteProduct(Long id); // Delete
}
