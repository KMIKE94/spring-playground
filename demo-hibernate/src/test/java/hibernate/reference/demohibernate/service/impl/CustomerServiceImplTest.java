package hibernate.reference.demohibernate.service.impl;

import hibernate.reference.demohibernate.model.Customer;
import hibernate.reference.demohibernate.repo.CustomerRepository;
import hibernate.reference.demohibernate.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerServiceImplTest {

    private List<Customer> customerList = new ArrayList<>();

    @Autowired
    CustomerService customerService;

    @MockBean
    CustomerRepository repository;

    @BeforeEach
    public void setup() {
        customerList.addAll(List.of(new Customer("Keith", "White"), new Customer("Emma", "Mullen")));
    }

    @Test
    public void testFindAllCustomers() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Customer("Keith", "White"), new Customer("Emma", "Mullen")));
        List<Customer> customers = customerService.findAllCustomers();
        for(int i=0;i<customers.size();i++){
            assertThat(customers.get(i).getFirstName()).isEqualTo(customerList.get(i).getFirstName());
            assertThat(customers.get(i).getLastName()).isEqualTo(customerList.get(i).getLastName());
        }
    }

}
