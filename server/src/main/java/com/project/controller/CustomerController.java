package com.project.controller;

import com.project.model.Customer;
import com.project.repository.dao.ResourceNotFoundException;
import com.project.service.CustomerService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/customers/")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public Collection<Customer> getAllCustomers() { return service.getAll(); }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        try {
            return service.getById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(),
                    e
            );
        }
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(
            @Valid @RequestBody Customer customer) {
        var entity = service.create(customer);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("{id}")
                        .buildAndExpand(entity.getId().toString())
                        .toUri()
        ).body(entity);
    }

    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable Long id,
            @Valid @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Long id) { service.delete(id); }
}