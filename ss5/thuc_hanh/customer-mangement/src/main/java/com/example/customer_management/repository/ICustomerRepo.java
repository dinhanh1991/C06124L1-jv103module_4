package com.example.customer_management.repository;

import java.util.List;
import com.example.customer_management.model.Customer;

public interface ICustomerRepo {
    List<Customer> getAllCustomers();

    Customer getCustomer(int customerId);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
