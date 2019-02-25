package repository.dao;

import exception.ResourceNotFoundException;
import model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.CustomerRepository;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

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

    public Customer update(Long id, List<Consumer> list) {
        var customer = getById(id);
        
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