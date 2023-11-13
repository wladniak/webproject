package pl.wla.webproject.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.Invoice;
import pl.wla.webproject.domain.mapper.DomainToEntityMapper;
import pl.wla.webproject.domain.mapper.EntityToDomainMapper;
import pl.wla.webproject.repository.InvoiceRepository;
import pl.wla.webproject.repository.entities.InvoiceEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private EntityToDomainMapper entityToDomainMapper;

    @Autowired
    private DomainToEntityMapper domainToEntityMapper;


    public List<Invoice> getInvoices(){
        List<InvoiceEntity> invoiceEntity = invoiceRepository.findAll();
        return invoiceEntity.stream().map(entityToDomainMapper::mapInvoice).collect(Collectors.toList());
    }

    public List<Invoice> getInvoiceDetails(final int id){
        List<InvoiceEntity> invoiceEntity = invoiceRepository.findByInvNo(id);
        return invoiceEntity.stream().map(entityToDomainMapper::mapInvoice).collect(Collectors.toList());
    }

    public void addInvoice(final Invoice invoice){
        invoiceRepository.save(domainToEntityMapper.mapInvoice(invoice));
    }

    public void deleteInvoice(final int id){
        List<InvoiceEntity> invoiceEntity = invoiceRepository.findByInvNo(id);

        for (InvoiceEntity inv : invoiceEntity) {
            invoiceRepository.delete(inv);
        }
    }

}
