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


    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "rate")
    VatRate entityToDomain(VatRateEntity vatRate);
}
