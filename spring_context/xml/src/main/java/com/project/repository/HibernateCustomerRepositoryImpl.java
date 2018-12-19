package com.project.repository;

import com.project.model.Customer;

import java.util.List;

public class HibernateCustomerRepositoryImpl
        implements CustomerRepository {

    /* (non-Javadoc)
     * @see com.pluralsight.anno.repository.CustomerRepository#findAll()
     */
    public List<Customer> findAll() {
        List<Customer> customers = new java.util.ArrayList<>();
        var customer = new Customer();

        customer.setFirstName("Dima");
        customer.setLastName("Hansen");

        customers.add(customer);

        return customers;
    }
}