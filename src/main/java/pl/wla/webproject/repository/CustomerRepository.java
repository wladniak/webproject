package pl.wla.webproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wla.webproject.repository.entities.CustomerEntity;

import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    List<CustomerEntity> findAll();

    List<CustomerEntity> findById(final int id);
}
