import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.CustomerRepository;
import service.CustomerService;
import xml.CustomerServiceImpl;
import xml.HibernateCustomerRepositoryImpl;

@Configuration
public class AppConfig {
    @Bean(name = "customerService")
    public CustomerService getCustomerService() {
//        var service = new CustomerServiceImpl(getCustomerRepository());
        var service = new CustomerServiceImpl();
        service.setCustomerRepository(getCustomerRepository());
        return service;
    }

    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository() {
        return new HibernateCustomerRepositoryImpl();
    }
}