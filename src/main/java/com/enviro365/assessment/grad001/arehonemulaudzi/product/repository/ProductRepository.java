package com.enviro365.assessment.grad001.arehonemulaudzi.product.repository;

import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String productName);
}
