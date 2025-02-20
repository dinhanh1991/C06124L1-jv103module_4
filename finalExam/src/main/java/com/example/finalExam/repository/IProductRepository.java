package com.example.finalExam.repository;

import com.example.finalExam.model.Product;
import com.example.finalExam.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByProductType(ProductType productType, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqual(Integer minPrice, Pageable pageable);;
    Page<Product> findByNameContainingIgnoreCaseAndProductTypeAndPriceGreaterThanEqual(
            String name, ProductType productType, Integer minPrice, Pageable pageable);
}
