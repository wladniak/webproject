package pl.wla.webproject.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.wla.webproject.domain.Customer;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.rest.dto.CustomerDTO;
import pl.wla.webproject.rest.dto.VatRateDTO;

@Mapper(implementationName = "ControlerDTOToDomainMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ControlerDTOToDomainMapper {
    @Mapping(source = "code",target = "code")
    @Mapping(source = "vatRate",target = "rate")
    VatRate mapVat(VatRateDTO vatRate);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    Customer mapCustomer(CustomerDTO customer);

}
