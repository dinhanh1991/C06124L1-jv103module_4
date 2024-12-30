package com.example.customer_data.repository;

import com.example.customer_data.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> getAllCustomers();
    Customer getCustomer(int customerId);
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
