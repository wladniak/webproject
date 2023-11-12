package pl.wla.webproject.rest.mapper;



import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.rest.dto.VatRateDTO;

@Mapper(implementationName = "VatRateMapperRestImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, implementationPackage = "pl.wla.webproject.rest.mapper")
public interface VatRateMapperRest {
    VatRateMapperRest INSTANCE = Mappers.getMapper(VatRateMapperRest.class);


    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "rate")
    VatRateDTO domainToControlerDTO(VatRate vatRate);


}
