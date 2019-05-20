import com.project.repository.CustomerRepository;
import com.project.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xml.CustomerServiceImpl;
import xml.HibernateCustomerRepositoryImpl;

@Configuration
@PropertySource("app.properties")
public class AppConfig {
    @Bean(name = "customerService")
    public CustomerService getCustomerService() {
        //        var com.project.service = new CustomerServiceImpl
        //        (getCustomerRepository());
        var service = new CustomerServiceImpl();
        service.setCustomerRepository(getCustomerRepository());
        return service;
    }

    @Bean(name = "customerRepository")
    CustomerRepository getCustomerRepository() {
        return new HibernateCustomerRepositoryImpl();
    }
}