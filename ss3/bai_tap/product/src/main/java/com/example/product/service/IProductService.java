package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    Product getProduct(int id);
    void saveProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    List<Product> searchProduct(String keyword);
}
