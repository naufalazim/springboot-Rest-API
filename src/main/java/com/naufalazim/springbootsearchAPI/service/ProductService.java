package com.naufalazim.springbootsearchAPI.service;

import com.naufalazim.springbootsearchAPI.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProducts(String query); //Search
    Product createdProduct(Product product);    //Created
}
