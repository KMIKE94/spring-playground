package hibernate.reference.demohibernate.service.impl;

import hibernate.reference.demohibernate.exception.CustomerNotFoundException;
import hibernate.reference.demohibernate.model.Customer;
import hibernate.reference.demohibernate.repo.CustomerRepository;
import hibernate.reference.demohibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()) {
            throw new CustomerNotFoundException(String.format("Customer Not Found with id %d", id));
        }
        return customer.get();
    }
}
