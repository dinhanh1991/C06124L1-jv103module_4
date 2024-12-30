package com.example.customer_data.repository;

import com.example.customer_data.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private static final List<Customer> customers = new ArrayList<Customer>();
    static {
        customers.add(new Customer(1,"Sa Thông Thiên","hoanghalaoquy@gmail.com","Gia Hưng, Nam Tống"));
        customers.add(new Customer(2,"Khưu Xứ Cơ","truongxuantu@gmail.com","Chung Nam Sơn, Nam Tống"));
        customers.add(new Customer(3,"Chu Tử Liễu","thứinh@gmail.com","Vân Nam, Đại Lý"));
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if(customerId==customer.getId()) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (Customer c : customers) {
            if(c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
                c.setAddress(customer.getAddress());
            }
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        customers.removeIf(customer -> customerId == customer.getId());
    }
}
