package pl.wla.webproject.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.domain.mapper.DomainToEntityMapper;
import pl.wla.webproject.domain.mapper.EntityToDomainMapper;
import pl.wla.webproject.repository.VatRateDAO;
import pl.wla.webproject.repository.entities.VatRateEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VatRateService {

    private final VatRateDAO vatRateDAO;


    private final EntityToDomainMapper entityToDomainMapper;


    private final DomainToEntityMapper domainToEntityMapper;

    public List<VatRate> getVatRates() {
        List<VatRateEntity> vatRateEntity = vatRateDAO.findAll();
        return vatRateEntity.stream().map(entityToDomainMapper::mapVat).collect(Collectors.toList());
    }

    public List<VatRate> getVatListByRate(int rate) {
        List<VatRateEntity> vatRateEntity = vatRateDAO.findByRate(rate);
        return vatRateEntity.stream().map(entityToDomainMapper::mapVat).collect(Collectors.toList());
    }

    public VatRate getVatDetails(final String code) {
        VatRateEntity vatRateEntity = vatRateDAO.findByCode(code);
        return entityToDomainMapper.mapVat(vatRateEntity);
    }

    public void addVatRate(final VatRate vatRate) {
        vatRateDAO.save(domainToEntityMapper.mapVat(vatRate));
    }

    public void deleteVatRate(final String code) {
        VatRateEntity vatRateEntity = vatRateDAO.findByCode(code);
        vatRateDAO.delete(vatRateEntity);

    }
}
