package com.naufalazim.springbootsearchAPI.repository;

import com.naufalazim.springbootsearchAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    //Return List of Product Based on Criteria:
    @Query("SELECT p FROM Product p WHERE "
            + "p.name LIKE CONCAT('%',:query, '%')"
            + "Or p.description LIKE CONCAT('%',:query, '%')")
    List<Product> searchProducts(String query);

}
