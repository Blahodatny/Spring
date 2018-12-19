package com.project.service;

import com.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
    }

    //    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        System.out.println("We are using constructor injection!!!");
        this.customerRepository = repository;
    }

    /* (non-Javadoc)
     * @see com.pluralsight.anno.service.CustomerService#findAll()
     */

    public List<com.project.model.Customer> findAll() {
        return customerRepository.findAll();
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection!!!");
        this.customerRepository = customerRepository;
    }
}