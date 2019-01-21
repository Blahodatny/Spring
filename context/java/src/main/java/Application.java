import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CustomerService;

class Application {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        var service =
                appContext.getBean("customerService", CustomerService.class);

        System.out.println(service.findAll().get(0).getFirstName());
    }
}