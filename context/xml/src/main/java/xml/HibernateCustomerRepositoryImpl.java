package xml;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    @Value("${dbUser}")
    private String dbUser;

    public List<Customer> findAll() {
        System.out.print("Database user is: " + dbUser + "\n");
        List<Customer> customers = new ArrayList<>();
        var customer = new Customer();

        customer.setFirstName("Dima");
        customer.setLastName("Hansen");

        customers.add(customer);

        return customers;
    }
}