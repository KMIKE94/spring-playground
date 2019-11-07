package hibernate.reference.demohibernate.service;

import hibernate.reference.demohibernate.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();
    Customer findCustomerById(long id);

}
