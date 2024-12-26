package com.example.customer.controller;

import com.example.customer.repository.CustomerRop;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    private CustomerRop customerRop = new CustomerRop();
    @GetMapping("/customers")
   public String showListCustomer(HttpServletRequest request) {
        List<Customer> customerList =customerRop.getListCustomer();
       request.setAttribute("customerList",customerList);
        return "list";
    }
    /*@GetMapping()
    public String showCustomer() {
        return "view";
    }*/
}
