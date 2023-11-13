package pl.wla.webproject.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wla.webproject.repository.entities.CustomerEntity;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    List<CustomerEntity> findAll();

    List<CustomerEntity> findById(final int id);
}
