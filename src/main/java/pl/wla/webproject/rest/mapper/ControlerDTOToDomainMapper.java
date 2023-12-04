package pl.wla.webproject.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.wla.webproject.domain.*;
import pl.wla.webproject.rest.dto.*;

@Mapper(implementationName = "ControlerDTOToDomainMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ControlerDTOToDomainMapper {
    @Mapping(source = "code", target = "code")
    @Mapping(source = "vatRate", target = "rate")
    VatRate mapVat(VatRateDTO vatRate);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Customer mapCustomer(CustomerDTO customer);


    @Mapping(source = "posInvNo", target = "posInvNo")
    @Mapping(source = "posNo", target = "posNo")
    @Mapping(source = "vat", target = "vat")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "posDescription", target = "posDescription")
    InvoicePosition mapInvoicePositions(InvoicePositionDTO positions);

    @Mapping(source = "invNo", target = "invNo")
    @Mapping(source = "invDate", target = "invDate")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "positions", target = "positions")
    Invoice mapInvoice(InvoiceDTO invoice);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "text", target = "text")
    MessageAQ mapMessage(MessageDTO message);
}
