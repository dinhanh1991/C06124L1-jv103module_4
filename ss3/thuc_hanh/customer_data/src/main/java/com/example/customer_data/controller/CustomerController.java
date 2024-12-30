package com.example.customer_data.controller;

import com.example.customer_data.model.Customer;
import com.example.customer_data.service.CustomerService;
import com.example.customer_data.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private ICustomerService customerService =new CustomerService();
    @GetMapping("")
    public String home(Model model) {
        List<Customer> customers =customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "home";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
      model.addAttribute("customer",customerService.getCustomer(id));
      return "view";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer",customerService.getCustomer(id));
        return "update";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    @PostMapping("/update")
        public String update(Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customers";
        }
        @GetMapping("/{id}/delete")
            public String delete(@PathVariable int id, Model model) {
                model.addAttribute("customer", customerService.getCustomer(id));
                return "/delete";
        }
        @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
        }
}
