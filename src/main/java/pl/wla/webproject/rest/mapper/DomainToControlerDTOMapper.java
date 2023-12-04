package pl.wla.webproject.rest.mapper;


import org.mapstruct.*;
import pl.wla.webproject.domain.*;
import pl.wla.webproject.rest.dto.*;

@Mapper(implementationName = "DomainToControlerDTOMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DomainToControlerDTOMapper {

    @Mapping(source = "code", target = "code")
    @Mapping(source = "rate", target = "vatRate")
    @Mapping(target = "vatRateStr", ignore = true)
    VatRateDTO mapVat(VatRate vatRate);

    @AfterMapping
    default void convertRateToStr(@MappingTarget VatRateDTO vatRateDTO) {
        vatRateDTO.setVatRateStr(vatRateDTO.getVatRate() + "%");
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CustomerDTO mapCustomer(Customer customer);


    @Mapping(source = "posInvNo", target = "posInvNo")
    @Mapping(source = "posNo", target = "posNo")
    @Mapping(source = "vat", target = "vat")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "posDescription", target = "posDescription")
    InvoicePositionDTO mapInvoicePositions(InvoicePosition positions);

    @Mapping(source = "invNo", target = "invNo")
    @Mapping(source = "invDate", target = "invDate")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "positions", target = "positions")
    InvoiceDTO mapInvoice(Invoice invoice);


    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    CommentRestDTO mapComment(CommentRest comment);
}
