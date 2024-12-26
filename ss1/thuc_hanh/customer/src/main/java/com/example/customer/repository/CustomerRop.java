package com.example.customer.repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRop implements ICustomerRop {
    private static List<Customer> customers ;

    static{
        customers = new ArrayList<Customer>();
        customers.add(new Customer(1,"Thái Bình","Hạnh","hanh@gmail.com"));
        customers.add(new Customer(2,"Hòa Bình","Linh","Linh@gmail.com"));
        customers.add(new Customer(3,"Ninh Bình","Tan","Tan@gmail.com"));
    }
    @Override
    public List<Customer> getListCustomer() {
        return customers;
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void deleteCustomer(int id) {
            customers.removeIf(customer -> customer.getId() == id);
    }

    @Override
    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
