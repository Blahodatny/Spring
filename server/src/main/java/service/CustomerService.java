package service;

import model.customer.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer create(Customer customer);

    void delete(Long id);

    Collection<Customer> getAll();

    Customer getById(Long id);
}