package annotation;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import service.CustomerService;

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

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection!!!");
        this.customerRepository = customerRepository;
    }
}