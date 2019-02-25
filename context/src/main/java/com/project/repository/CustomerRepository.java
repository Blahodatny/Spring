package com.project.repository;

import com.project.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}