package repository.dao;

import exception.ResourceNotFoundException;
import model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.CustomerRepository;

import java.util.Collection;

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