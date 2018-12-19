package com.project.repository;

import java.util.List;

import com.project.model.Customer;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl
        implements com.project.repository.CustomerRepository {

    /* (non-Javadoc)
     * @see com.pluralsight.anno.repository.CustomerRepository#findAll()
     */
    public List<Customer> findAll() {
        List<Customer> customers = new java.util.ArrayList<>();
        var customer = new Customer();

        customer.setFirstName("Bryan");
        customer.setLastName("Hansen");

        customers.add(customer);

        return customers;
    }
}