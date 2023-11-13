package pl.wla.webproject.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.domain.mapper.EntityToDomainMapper;
import pl.wla.webproject.repository.VatRateRepository;
import pl.wla.webproject.repository.entities.VatRateEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VatRateService {

    @Autowired
    private VatRateRepository vatRateRepository;

    @Autowired
    private EntityToDomainMapper entityToDomainMapper;


public List<VatRate> getVatRates(){
    List<VatRateEntity> vatRateEntity = vatRateRepository.findAll();
    return vatRateEntity.stream().map(entityToDomainMapper::entityToDomain).collect(Collectors.toList());
}

    public List<VatRate> getVatDetails(String code){
        List<VatRateEntity> vatRateEntity = vatRateRepository.findByCode(code);
        return vatRateEntity.stream().map(entityToDomainMapper::entityToDomain).collect(Collectors.toList());
    }
}
