package com.project.service.customer;

import com.project.model.customer.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer create(Customer customer);

    void delete(Long id);

    Customer update(Long id, Customer customer);

    Collection<Customer> getAll();

    Customer getById(Long id);
}