package com.example.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return  "index";
    }
}