package pl.wla.webproject.domain.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.repository.entities.VatRateEntity;



@Mapper(implementationName = "VatRateMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VatRateMapper {
    VatRateMapper INSTANCE = Mappers.getMapper(VatRateMapper.class);

    @Mapping(source = "vatRate",target = "rate")
    VatRateEntity domainToEntity(VatRate vatRate);

    @Mapping(source = "rate",target = "vatRate")
    VatRate entityToDomain(VatRateEntity vatRate);
}
