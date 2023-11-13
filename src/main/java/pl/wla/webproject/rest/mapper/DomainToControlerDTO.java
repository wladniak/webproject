package pl.wla.webproject.rest.mapper;



import org.mapstruct.*;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.rest.dto.VatRateDTO;

@Mapper(implementationName = "DomainToControlerDTOImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, implementationPackage = "pl.wla.webproject.rest.mapper")
public interface DomainToControlerDTO {

    @Mapping(source = "code",target = "code")
    @Mapping(source = "rate",target = "rate")
    @Mapping(target = "vatRateStr",ignore = true)
    VatRateDTO domainToControlerDTO(VatRate vatRate);

    @AfterMapping
    default void convertRateToStr(@MappingTarget VatRateDTO vatRateDTO){
        vatRateDTO.setVatRateStr(vatRateDTO.getRate()+"%");
    }
}
