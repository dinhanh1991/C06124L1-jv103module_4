package com.example.customer_data.service;

import com.example.customer_data.model.Customer;
import com.example.customer_data.repository.CustomerRepo;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final CustomerRepo customerRepo=new CustomerRepo();
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    @Override
    public Customer getCustomer(int customerId) {
        return customerRepo.getCustomer(customerId);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepo.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepo.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepo.deleteCustomer(customerId);
    }
}
