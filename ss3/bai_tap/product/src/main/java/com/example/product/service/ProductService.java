package com.example.product.service;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<Product>();
    static {
        products.add(new Product(1,"Dell inprison","Black",15000000,"Dell"));
        products.add(new Product(2,"Iphone 12 pro","Pink",12500000,"Apple"));
        products.add(new Product(3,"SamSung galaxy S21","White",14900000,"SamSung"));
        products.add(new Product(4,"Lenovo ideapad L340","Gray Sliver",17700000,"Lenovo"));
    }
    public List<Product> getProducts() {
        return products;
    }
    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public List<Product> searchProduct(String keyword) {
        List<Product> productsForByName =new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(keyword)) {
                productsForByName.add(product);
            }
        }
        return productsForByName;
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for(Product p : products) {
            if(p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setFirm(product.getFirm());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
