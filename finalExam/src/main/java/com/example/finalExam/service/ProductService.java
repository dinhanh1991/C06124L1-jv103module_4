package com.example.finalExam.service;

import com.example.finalExam.model.Product;
import com.example.finalExam.model.ProductType;
import com.example.finalExam.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
    public Page<Product> findByName(String name, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }
    public Page<Product> findByProductType(ProductType productType, Pageable pageable) {
        return productRepository.findByProductType(productType, pageable);
    }
    public Page<Product> findByPriceGreater(Integer minPrice, Pageable pageable) {
        return productRepository.findByPriceGreaterThanEqual(minPrice, pageable);
    }
    public Page<Product> findByNameAndProductTypeAndPriceGreaterThanEqual(String name, ProductType productType, Integer minPrice, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCaseAndProductTypeAndPriceGreaterThanEqual(name, productType, minPrice, pageable);
    }
    public void save(Product product) {
        productRepository.save(product);
    }
    @Transactional
    public void deleteProductByList(List<Integer> ids) {
        for (Integer id : ids) {
            productRepository.deleteById(id);
        }
    }

}
