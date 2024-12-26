package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @RequestMapping("/sandwich")
    public String showForm() {
        return "sandwich";
    }
    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null || condiment.length == 0) {
            model.addAttribute("message", "No condiments selected.");
        } else {
            model.addAttribute("condiments", condiment);
        }
        return "result";
    }
}
