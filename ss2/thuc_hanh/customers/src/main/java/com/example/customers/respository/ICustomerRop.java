package com.example.customers.respository;

import com.example.customers.model.Customer;

import java.util.List;

public interface ICustomerRop {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void saveCustomer(Customer customer);
    void updateCustomer(int id,String name,String address,String email);
    void deleteCustomer(int id);
}
