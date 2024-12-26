package com.example.calculator.controller;

import com.example.calculator.model.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculator calculator;

    @RequestMapping("/calculator")
    public String showForm() {
        return "calculator";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operation") String operation,
                            Model model) {

        double result = 0;
        String errorMessage = null;

        try {
            switch (operation) {
                case "add":
                    result = calculator.add(num1, num2);
                    break;
                case "subtract":
                    result = calculator.subtract(num1, num2);
                    break;
                case "multiply":
                    result = calculator.multiply(num1, num2);
                    break;
                case "divide":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    errorMessage = "Invalid operation";
                    break;
            }
        } catch (ArithmeticException e) {
            errorMessage = e.getMessage();
        }

        if (errorMessage != null) {
            model.addAttribute("error", errorMessage);
        } else {
            model.addAttribute("result", result);
        }

        return "calculator";
    }
}
