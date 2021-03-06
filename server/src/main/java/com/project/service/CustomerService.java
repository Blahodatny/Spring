package com.project.service;

import com.project.model.Customer;
import java.util.Collection;

public interface CustomerService {
    Customer create(Customer customer);

    void delete(Long id);

    Customer update(Long id, Customer customer);

    Collection<Customer> getAll();

    Customer getById(Long id);
}