package com.example.finalExam.repository;

import com.example.finalExam.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepo extends JpaRepository<ProductType, Integer> {
}
