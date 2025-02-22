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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private IProductTypeRepo productTypeRepo;
    @GetMapping()
    public ModelAndView listProducts(@RequestParam(name = "page",defaultValue = "0",required = false) int page) {
        ModelAndView mav = new ModelAndView("home");
        Pageable pageable =  PageRequest.of(page, 5);
        mav.addObject("currentPage", page);
        mav.addObject("productPage", productService.findAll(pageable));
        mav.addObject("productType", productTypeRepo.findAll());
        mav.addObject("totalPage",productService.findAll(pageable).getTotalPages());
        return mav;
    }
    @GetMapping("/search")
    public ModelAndView searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer productTypeId,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(name = "page",defaultValue = "0",required = false) int page) {
        ModelAndView mav = new ModelAndView("home");
        Pageable pageable =  PageRequest.of(page, 5);
        Page<Product> productPage;
        mav.addObject("productType",productTypeRepo.findAll());
        ProductType productType = null;
        if (productTypeId != null) {
          productType=productTypeRepo.findById(productTypeId).orElse(null) ;}
        if (name != null && !name.isEmpty() && productTypeId != null && minPrice != null) {
            productType = productTypeRepo.findById(productTypeId).orElse(null);
            productPage = productService.findByNameAndProductTypeAndPriceGreaterThanEqual(name, productType, minPrice, pageable);
        }

        else if (name != null && !name.isEmpty()) {
            productPage = productService.findByName(name, pageable);
        }
        else if (minPrice != null) {
            productPage = productService.findByPriceGreater(minPrice, pageable);
        } else if(productTypeId!= null) {
            productType = productTypeRepo.findById(productTypeId).orElse(null);
            productPage = productService.findByProductType(productType, pageable);
        }
        else {
            productPage = productService.findAll(pageable);
        }
        mav.addObject("currentPage", page);
        mav.addObject("productPage", productPage);
        mav.addObject("totalPage", productPage.getTotalPages());
        mav.addObject("name", name);
        mav.addObject("productTypeId", productTypeId);
        mav.addObject("minPrice", minPrice);
        return mav;
}
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productType",productTypeRepo.findAll());
        model.addAttribute("productDTO", new ProductDTO());
        return "productCreateForm";
    }
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                                BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
           model.addAttribute("productType",productTypeRepo.findAll());
            return "productCreateForm";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("productType",productTypeRepo.findAll());
        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
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
            model.addAttribute("productTypes",productTypeRepo.findAll());
            model.addAttribute("productDTO", productDTO);
            return "productEditForm";
        } else {
            return "errorPage";
        }
    }
    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                                BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("productType",productTypeRepo.findAll());
        if (bindingResult.hasErrors()) {
           model.addAttribute("productType",productTypeRepo.findAll());
            return "productEditForm";
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("productType",productTypeRepo.findAll());
        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        return "redirect:/products";
    }
    @PostMapping("/deleteProductByList")
    public String deleteProductByList(@RequestParam("selectedProductIds") String selectedProductIds,
                                      RedirectAttributes redirectAttributes) {
        if (selectedProductIds.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Không có sản phẩm nào được chọn để xóa!");
            return "redirect:/products";
        }

        List<Integer> productIds = Arrays.stream(selectedProductIds.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        productService.deleteProductByList(productIds);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/products";
    }
}
