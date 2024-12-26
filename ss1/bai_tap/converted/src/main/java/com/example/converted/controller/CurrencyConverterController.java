package com.example.converted.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CurrencyConverterController {

  @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping("/convert")
    public String convert(
            @RequestParam("rate") double rate,
            @RequestParam("usdAmount") double usdAmount,
            Model model) {

        double vndAmount = rate * usdAmount;
        model.addAttribute("vndAmount", vndAmount);
        model.addAttribute("usdAmount", usdAmount);
        model.addAttribute("rate", rate);
        return "result";
    }
}