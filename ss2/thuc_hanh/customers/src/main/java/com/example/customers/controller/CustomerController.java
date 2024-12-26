package com.example.customers.controller;

import com.example.customers.model.Customer;
import com.example.customers.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ModelAndView showCustomers() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.showAllCustomer();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("inform");
        Customer customer = customerService.showCustomerById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestParam int id, @RequestParam String name,
                                 @RequestParam String address, @RequestParam String email) {
        customerService.updateCustomer(id, name, address, email);
        return "redirect:/customers";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam int id, @RequestParam String name,
                              @RequestParam String address, @RequestParam String email) {
        Customer customer = new Customer(id, name, address, email);
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit-customer");
        Customer customer = customerService.showCustomerById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("add-customer");
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView showDeleteForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("delete-confirm");
        return modelAndView;
    }
}
