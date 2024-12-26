package com.example.customer.repository;

import model.Customer;

import java.util.List;

public interface ICustomerRop {
    public List<Customer>getListCustomer();
    public void insertCustomer(Customer customer);
    public void deleteCustomer(int id);
    public Customer getCustomerById(int id);
}
