package com.project.repository.dao;

import com.project.exception.ResourceNotFoundException;
import com.project.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.project.repository.CustomerRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@Component
public class CustomerDAO {
    private final CustomerRepository repository;

    @Autowired
    public CustomerDAO(CustomerRepository repository) {
        this.repository = repository;
    }

    private void response(Exception e, HttpStatus status) {
        throw new ResponseStatusException(status, e.getMessage(), e);
    }

    public Customer create(Customer customer) {
        try {
            return repository.save(customer);
        } catch (Exception e) {
            response(e, HttpStatus.BAD_REQUEST);
            return null;
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            response(e, HttpStatus.NOT_FOUND);
        }
    }

    public Customer update(Long id, Customer customer) {
        var entity = getById(id);
        entity.setPhone(customer.getPhone());
        entity.setCity(customer.getCity());
        entity.setStreet(customer.getStreet());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
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