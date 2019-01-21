package annotation;

import java.util.List;

import model.Customer;
import org.springframework.stereotype.Repository;
import repository.CustomerRepository;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    public List<Customer> findAll() {
        List<Customer> customers = new java.util.ArrayList<>();
        var customer = new Customer();

        customer.setFirstName("Bryan");
        customer.setLastName("Hansen");

        customers.add(customer);

        return customers;
    }
}