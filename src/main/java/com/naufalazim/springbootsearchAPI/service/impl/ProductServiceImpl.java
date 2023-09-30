package com.naufalazim.springbootsearchAPI.service.impl;

import com.naufalazim.springbootsearchAPI.entity.Product;
import com.naufalazim.springbootsearchAPI.repository.ProductRepository;
import com.naufalazim.springbootsearchAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

//    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createdProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        // Check if have existing ID:
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if(existingProductOptional.isPresent()) {
            //If product Id is exist...
            Product existingProduct = existingProductOptional.get();
            // Update the fields of the existing product with the data from the updated product
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setSku(updatedProduct.getSku());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setImage(updatedProduct.getImage());

            Product savedProduct =  productRepository.save(existingProduct);
            return savedProduct;
        } else {
            return null;
        }

    }

    @Override
    public void deleteProduct(Long id) {
         productRepository.deleteById(id);
    }

}
