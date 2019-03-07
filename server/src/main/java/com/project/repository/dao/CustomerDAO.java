package com.project.repository.dao;

import com.project.model.Customer;

import java.util.Collection;

public interface CustomerDAO {
    Customer create(Customer customer);

    void delete(Long id);

    Customer update(Long id, Customer customer);

    Collection<Customer> getAll();

    Customer getById(Long id);
}