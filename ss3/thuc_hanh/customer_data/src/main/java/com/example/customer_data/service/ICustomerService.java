package com.example.customer_data.service;

import com.example.customer_data.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer(int customerId);
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
