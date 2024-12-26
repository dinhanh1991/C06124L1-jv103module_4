package com.example.customers.respository;

import com.example.customers.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRop implements ICustomerRop{
    private static List<Customer> customers=new ArrayList<>();
    static{
        customers.add(new Customer(1,"Dương Quá","Cổ mộ_Chung Nam Sơn","quanhi@gmail.com"));
        customers.add(new Customer(2,"Đoàn Chính Thuần","Đại Lý, Vân Nam","changtraidatinh@gmail.com"));
        customers.add(new Customer(3,"Cam Bảo Bảo","Vạn Kiếm Cốc,Đại Lý, Vân Nam","baocam@gmail.com"));
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer=null;
        for(Customer c:customers){
            if(c.getId()==id){
                customer=c;
            }
        }
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void updateCustomer(int id, String name, String address, String email) {
        for(Customer c:customers){
            if(c.getId()==id){
                c.setName(name);
                c.setAddress(address);
                c.setEmail(email);
            }
        }

    }

    @Override
    public void deleteCustomer(int id) {
        customers.removeIf(c->c.getId()==id);
    }
}
