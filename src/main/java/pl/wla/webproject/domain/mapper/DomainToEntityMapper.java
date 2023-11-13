package pl.wla.webproject.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.wla.webproject.domain.Customer;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.repository.entities.CustomerEntity;
import pl.wla.webproject.repository.entities.VatRateEntity;

@Mapper(implementationName = "DomainToEntityMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DomainToEntityMapper {
    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "rate")
    VatRateEntity mapVat(VatRate tRate);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CustomerEntity mapCustomer(Customer customer);
}
