package pl.wla.webproject.rest.mapper;



import org.mapstruct.*;
import pl.wla.webproject.domain.Customer;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.rest.dto.CustomerDTO;
import pl.wla.webproject.rest.dto.VatRateDTO;

@Mapper(implementationName = "DomainToControlerDTOMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DomainToControlerDTOMapper {

    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "vatRate")
    @Mapping(target = "vatRateStr",ignore = true)
    VatRateDTO mapVat(VatRate vatRate);

    @AfterMapping
    default void convertRateToStr(@MappingTarget VatRateDTO vatRateDTO){
        vatRateDTO.setVatRateStr(vatRateDTO.getVatRate()+"%");
    }

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    CustomerDTO mapCustomer(Customer customer);

}
