package hibernate.reference.demohibernate.repo;

import java.util.List;
import java.util.Optional;

import hibernate.reference.demohibernate.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findAll();

    Optional<Customer> findById(long id);
}
