package com.example.customer_management.repository;

import com.example.customer_management.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepo implements ICustomerRepo {
  @PersistenceContext
  private EntityManager em;
    @Override
    public List<Customer> getAllCustomers() {
     String jpql = "select c from Customer as c";
      TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
      return query.getResultList();
    }
    @Override
    public Customer getCustomer(int customerId) {
       return em.find(Customer.class, customerId);
    }
    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        em.persist(customer);
    }
    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        em.merge(customer);

    }
    @Transactional
    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = em.find(Customer.class, customerId);
        if (customer != null) {
            em.remove(customer);
        }
    }
}
