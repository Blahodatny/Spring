package repository.dao;

import model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.CustomerRepository;

@Component
public class CustomerDAO {
    private final CustomerRepository repository;

    @Autowired
    public CustomerDAO(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}