package pl.wla.webproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wla.webproject.repository.entities.VatRateEntity;


import java.util.List;

@Repository
public interface VatRateRepository extends CrudRepository<VatRateEntity, Long> {
    List<VatRateEntity> findAll();

    List<VatRateEntity> findByCode(String code);
}


