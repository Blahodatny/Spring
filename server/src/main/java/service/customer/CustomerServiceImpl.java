package service.customer;

import model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.dao.CustomerDAO;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO dao;

    @Autowired
    public CustomerServiceImpl(CustomerDAO dao) {
        this.dao = dao;
    }

    public Customer create(Customer customer) {
        return dao.create(customer);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Collection<Customer> getAll() {
        return dao.getAll();
    }

    public Customer getById(Long id) {
        return dao.getById(id);
    }
}