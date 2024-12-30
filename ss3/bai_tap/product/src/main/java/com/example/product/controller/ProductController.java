package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import com.example.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService=new ProductService();
    @GetMapping("")
    public String home(Model model) {
        List<Product> products =productService.getProducts();
        model.addAttribute("products",products);
        return "home";
    }
    @GetMapping("/search")
    public String getListByName( @RequestParam(required = false, defaultValue = "") String name,Model model ) {
        List<Product> products =productService.searchProduct(name);
        model.addAttribute("products",products);
        return "home";
    }
    @GetMapping("/{id}/view")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product",product);
        return "view";
    }
    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.getProduct(id));
        return "update";
    }
    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product",new Product());
        return "create";
    }@GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model) {
        productService.deleteProduct(id);
        model.addAttribute("product",new Product());
        return "delete";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
