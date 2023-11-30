package pl.wla.webproject.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.Invoice;
import pl.wla.webproject.domain.mapper.DomainToEntityMapper;
import pl.wla.webproject.domain.mapper.EntityToDomainMapper;
import pl.wla.webproject.repository.InvoiceRepository;
import pl.wla.webproject.repository.entities.InvoiceEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary //to zostanie wziete jako pierwsze jesli mamy wiele implementacji, nie musimy stosowac Qualifier
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    private final EntityToDomainMapper entityToDomainMapper;

    private final DomainToEntityMapper domainToEntityMapper;


    @Override
    public List<Invoice> getInvoices() {
        List<InvoiceEntity> invoiceEntity = invoiceRepository.findAll();
        return invoiceEntity.stream().map(entityToDomainMapper::mapInvoice).collect(Collectors.toList());
    }

    @Override
    public List<Invoice> getInvoiceDetails(final int id) {
        List<InvoiceEntity> invoiceEntity = invoiceRepository.findByInvNo(id);
        return invoiceEntity.stream().map(entityToDomainMapper::mapInvoice).collect(Collectors.toList());
    }

    @Override
    public void addInvoice(final Invoice invoice) {
        invoiceRepository.save(domainToEntityMapper.mapInvoice(invoice));
    }

    @Override
    public void deleteInvoice(final int id) {
        List<InvoiceEntity> invoiceEntity = invoiceRepository.findByInvNo(id);

        for (InvoiceEntity inv : invoiceEntity) {
            invoiceRepository.delete(inv);
        }
    }

}
