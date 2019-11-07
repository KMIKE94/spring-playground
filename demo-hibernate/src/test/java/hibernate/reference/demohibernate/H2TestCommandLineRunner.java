package hibernate.reference.demohibernate;

import hibernate.reference.demohibernate.model.Customer;
import hibernate.reference.demohibernate.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class H2TestCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(H2TestCommandLineRunner.class);

    @Autowired
    CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Customer("Keith", "White"));
        repository.save(new Customer("Emma", "Mullen"));
    }
}
