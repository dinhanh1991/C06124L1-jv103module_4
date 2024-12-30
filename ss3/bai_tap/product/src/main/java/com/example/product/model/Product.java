package com.example.product.model;

public class Product {
    int id;
    String name;
    String description;
    int price;
    String firm;

    public Product() {
    }
    public Product(int id, String name, String description, int price, String firm) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.firm = firm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }
}
