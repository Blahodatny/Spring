package com.project.service;

import com.project.model.Customer;
import com.project.repository.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO dao;

    public Customer create(Customer customer) {
        return dao.create(customer);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Customer update(Long id, Customer customer) {
        return dao.update(id, customer);
    }

    public Collection<Customer> getAll() {
        return dao.getAll();
    }

    public Customer getById(Long id) {
        return dao.getById(id);
    }
}