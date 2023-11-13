package pl.wla.webproject.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.wla.webproject.domain.Customer;
import pl.wla.webproject.domain.Invoice;
import pl.wla.webproject.domain.InvoicePosition;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.repository.entities.CustomerEntity;
import pl.wla.webproject.repository.entities.InvoiceEntity;
import pl.wla.webproject.repository.entities.InvoicePositionEntity;
import pl.wla.webproject.repository.entities.VatRateEntity;

@Mapper(implementationName = "DomainToEntityMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DomainToEntityMapper {
    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "rate")
    VatRateEntity mapVat(VatRate tRate);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CustomerEntity mapCustomer(Customer customer);


    @Mapping(source = "posInvNo", target = "posInvNo")
    @Mapping(source = "posNo", target = "posNo")
    @Mapping(source = "vat", target = "vat")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "posDescription", target = "posDescription")
    InvoicePositionEntity mapInvoicePositions(InvoicePosition positions);
    @Mapping(source = "invNo", target = "invNo")
    @Mapping(source = "invDate", target = "invDate")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "positions", target = "positions")
    InvoiceEntity mapInvoice(Invoice invoice);

}
