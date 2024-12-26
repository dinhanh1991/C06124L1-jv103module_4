package com.example.customers.service;

import com.example.customers.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> showAllCustomer()        ;
    public Customer showCustomerById(int id) ;
    public void addCustomer(Customer customer);
    public void updateCustomer(int id,String name,String address,String email) ;
    public void deleteCustomer(int id) ;
}
