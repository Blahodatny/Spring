package com.project.service;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(CustomerRepository repository) {
        System.out.println("We are using constructor injection!!!");
        this.customerRepository = repository;
    }

    /* (non-Javadoc)
     * @see com.pluralsight.anno.service.CustomerService#findAll()
     */

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection!!!");
        this.customerRepository = customerRepository;
    }
}