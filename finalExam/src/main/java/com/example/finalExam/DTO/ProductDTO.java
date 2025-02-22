package com.example.finalExam.DTO;

import com.example.finalExam.model.Product;
import com.example.finalExam.model.ProductType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, message = "Tên không được ít hơn 5 kí tự")
    @Size(max = 50, message = "Tên không được vượt quá 50 kí tự")
    private String name;

    @NotNull(message = "Vui lòng điền số tiền")
    @Min(value = 100000, message = "Giá sản phẩm phải ít nhất là 100.000 VND")
    private Integer price;
    @NotNull(message = "Tình trạng không được để trống")
    private Product.ProductStatus status;
    @NotNull(message = "Điền chủng loại vào")
    private ProductType productType;
    public ProductDTO() {}
    public ProductDTO(Integer id, String name, Integer price, Product.ProductStatus status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product.ProductStatus getStatus() {
        return status;
    }

    public void setStatus(Product.ProductStatus status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
