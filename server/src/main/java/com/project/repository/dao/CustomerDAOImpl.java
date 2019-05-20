package com.project.repository.dao;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private CustomerRepository repository;

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public void delete(Long id) { repository.deleteById(id); }

    public Customer update(Long id, Customer customer) {
        var entity = getById(id);
        entity.updateWith(customer);
        return repository.save(entity);
    }

    public Collection<Customer> getAll() { return repository.findAll(); }

    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer with id: " + id + " is not found!!!"));
    }
}