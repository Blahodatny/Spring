import com.project.repository.CustomerRepository;
import com.project.repository.HibernateCustomerRepositoryImpl;
import com.project.service.CustomerService;
import com.project.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.project"})
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