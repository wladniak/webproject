package pl.wla.webproject.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wla.webproject.repository.entities.InvoiceEntity;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity,Long> {
    List<InvoiceEntity> findAll();

    List<InvoiceEntity> findByInvNo(final int invNo);
}
