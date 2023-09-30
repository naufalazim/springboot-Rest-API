package com.naufalazim.springbootsearchAPI.controller;

import com.naufalazim.springbootsearchAPI.entity.Product;
import com.naufalazim.springbootsearchAPI.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    //Link: /api/v1/products

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Return list of products:"/search?query={}"
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    // Create Product
    @PostMapping
    public Product createdProduct(@RequestBody Product product) {
        return productService.createdProduct(product);
    }

    // Get product
    @GetMapping("all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable Long id, @RequestBody Product updatedProduct)
    {
       Product product = productService.updateProduct(id, updatedProduct);

//       if(product != null)
//       {
//           return ResponseEntity.ok(product);
//       }
//       else
//       {
//           return ResponseEntity.notFound().build();
//       }

        //Ternary Method:
        return (product != null) ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();

    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable  Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
