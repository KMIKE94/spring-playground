package hibernate.reference.demohibernate.service.impl;

import hibernate.reference.demohibernate.model.Customer;
import hibernate.reference.demohibernate.repo.CustomerRepository;
import hibernate.reference.demohibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
