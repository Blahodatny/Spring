package com.project.repository.dao;

import com.project.exception.ResourceNotFoundException;
import com.project.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.repository.CustomerRepository;

import java.util.Collection;

@Component
public class CustomerDAO {
    @Autowired
    private CustomerRepository repository;

/*    @Autowired
    public CustomerDAO(CustomerRepository repository) {
        this.repository = repository;
    }*/

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Customer update(Long id, Customer customer) {
        var entity = getById(id);
        entity.updateWith(customer);
        return repository.save(entity);
    }

    public Collection<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getById(Long id) {
        var customer = repository.findById(id);
        return customer.orElseThrow(() ->
                new ResourceNotFoundException("Customer with id: " + id + " is not found!!!")
        );
    }
}