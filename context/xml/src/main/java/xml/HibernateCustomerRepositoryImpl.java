package xml;

import model.Customer;
import repository.CustomerRepository;

import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    public List<Customer> findAll() {
        List<Customer> customers = new java.util.ArrayList<>();
        var customer = new Customer();

        customer.setFirstName("Dima");
        customer.setLastName("Hansen");

        customers.add(customer);

        return customers;
    }
}