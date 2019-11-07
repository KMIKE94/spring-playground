package hibernate.reference.demohibernate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.reference.demohibernate.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CustomerControllerTest {

    private List<Customer> customerList = new ArrayList<>();

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        Customer customer1 = new Customer("Keith", "White");
        Customer customer2 = new Customer("Emma", "Mullen");
        customerList.add(customer1);
        customerList.add(customer2);
    }

    @Test
    public void testGetCustomers() throws Exception {
        ResultActions result = mockMvc.perform(get("/customers"));
        List<Customer> customerResult = List.of(
                objectMapper
                        .readValue(result.andReturn().getResponse().getContentAsString(), Customer[].class));
        for(int i = 0;i<customerResult.size();i++){
            assertThat(customerResult.get(i).getFirstName()).isEqualTo(customerList.get(i).getFirstName());
            assertThat(customerResult.get(i).getLastName()).isEqualTo(customerList.get(i).getLastName());
        }
    }

}
