package com.project.service.customer;

import com.project.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.repository.dao.CustomerDAOImpl;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAOImpl dao;

    @Autowired
    public CustomerServiceImpl(CustomerDAOImpl dao) {
        this.dao = dao;
    }

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