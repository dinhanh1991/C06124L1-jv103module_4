package com.example.to_khai_y_te.controller;

import com.example.to_khai_y_te.entity.ToKhaiYTe;
import com.example.to_khai_y_te.repository.IToKhaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ToKhaiController {
    @Autowired
    private IToKhaiRepository repository;

    @GetMapping("/")
    public String hienThiForm(Model model) {
        model.addAttribute("toKhai", new ToKhaiYTe());
        return "form";
    }

    @PostMapping("/submit-form")
    public String luuToKhai(@ModelAttribute @Valid ToKhaiYTe toKhai, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        repository.save(toKhai);
        return "redirect:/forms";
    }

    @GetMapping("/forms")
    public String hienThiDanhSach(Model model) {
        model.addAttribute("forms", repository.findAll());
        return "forms";
    }

    @GetMapping("/update-form/{id}")
    public String hienThiFormCapNhat(@PathVariable Long id, Model model) {
        ToKhaiYTe toKhai = repository.findById(id).orElse(null);
        model.addAttribute("toKhai", toKhai);
        return "form";
    }

    @PostMapping("/update-form/{id}")
    public String capNhatToKhai(@PathVariable Long id, @ModelAttribute @Valid ToKhaiYTe toKhai, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        toKhai.setId(id);
        repository.save(toKhai);
        return "redirect:/forms";
    }
}

