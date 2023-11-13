package pl.wla.webproject.domain.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.repository.entities.VatRateEntity;



@Mapper(implementationName = "EntityToDomainMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EntityToDomainMapper {


    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "rate")
    VatRate entityToDomain(VatRateEntity vatRate);
}
