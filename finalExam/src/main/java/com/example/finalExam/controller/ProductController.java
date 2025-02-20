package com.example.finalExam.controller;

import com.example.finalExam.DTO.ProductDTO;
import com.example.finalExam.model.Product;
import com.example.finalExam.model.ProductType;
import com.example.finalExam.repository.IProductTypeRepo;
import com.example.finalExam.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private IProductTypeRepo productTypeRepo;
    @GetMapping()
    public ModelAndView listProducts(Model model,
                                     @RequestParam(name = "page",defaultValue = "0",required = false) int page) {
        ModelAndView mav = new ModelAndView("home");
        Pageable pageable = PageRequest.of(page, 5);
        System.out.println(productTypeRepo.findAll());
        mav.addObject("productPage", productService.findAll(pageable));
        mav.addObject("productType", productTypeRepo.findAll());
        mav.addObject("totalPage",productService.findAll(pageable).getTotalPages());
        return mav;
    }
    @GetMapping("/search")
    public String searchProducts( @RequestParam(required = false) String name,
                                  @RequestParam(required = false) ProductType productType,
                                  @RequestParam(required = false) Integer minPrice,
                                  @RequestParam(required = false) Integer maxPrice,
                                  @PageableDefault(size = 5) Pageable pageable,
                                  Model model){
            Page<Product> productPage;
        model.addAttribute("productType",productTypeRepo.findAll());
            if (name != null & productType != null & minPrice != null ) {
                productPage = productService.findByNameAndProductTypeAndPriceBetween(name, productType, minPrice, pageable);
            } else if (name != null) {
                productPage = productService.findByName(name, pageable);
            } else if (productType != null) {
                productPage = productService.findByProductType(productType, pageable);
            } else if (minPrice != null) {
                productPage = productService.findByPriceBetween(minPrice, pageable);
            }
            else {
                productPage=productService.findAll(pageable);
            }

            model.addAttribute("productPage", productPage);
            return "home";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productTypes",productTypeRepo.findAll());
        model.addAttribute("productDTO", new ProductDTO());
        return "productCreateForm";
    }
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "productCreateForm";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        model.addAttribute("productType",productTypeRepo.findAll());

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);

            model.addAttribute("productDTO", productDTO);
            return "productEditForm";
        } else {
            return "errorPage";
        }
    }
    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                                BindingResult bindingResult, Model model) {
        model.addAttribute("productType",productTypeRepo.findAll());
        if (bindingResult.hasErrors()) {
            return "productEditForm";
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        return "redirect:/products";
    }
    @PostMapping("/deleteProductByList")
    public String deleteProductByList(@RequestParam("selectedProductIds") List<Integer> selectedProductIds) {
        productService.deleteProductByList(selectedProductIds);
        return "redirect:/products";
    }
}
