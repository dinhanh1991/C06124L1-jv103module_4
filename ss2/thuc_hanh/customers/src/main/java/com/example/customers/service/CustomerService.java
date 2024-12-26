package com.example.customers.service;

import com.example.customers.model.Customer;
import com.example.customers.respository.CustomerRop;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final CustomerRop customerRop = new CustomerRop();

    public List<Customer> showAllCustomer() {
        return customerRop.getAllCustomers();
    }

    public Customer showCustomerById(int id) {
        return customerRop.getCustomerById(id);
    }

    public void addCustomer(Customer customer) {
        customerRop.saveCustomer(customer);
    }

    public void updateCustomer(int id, String name, String address, String email) {
        customerRop.updateCustomer(id, name, address, email);
    }

    public void deleteCustomer(int id) {
        customerRop.deleteCustomer(id);
    }
}
