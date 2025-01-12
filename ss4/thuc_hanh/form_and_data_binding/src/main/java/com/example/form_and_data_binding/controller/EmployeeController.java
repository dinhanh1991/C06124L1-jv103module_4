package com.example.form_and_data_binding.controller;

import com.example.form_and_data_binding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }
    @RequestMapping(value = "/addEmployee", method = {RequestMethod.GET, RequestMethod.POST})
    public String submit(@ModelAttribute Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id",employee.getId());
        return "inform";
    }
}
