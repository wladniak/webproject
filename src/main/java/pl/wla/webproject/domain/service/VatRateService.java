package pl.wla.webproject.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.domain.mapper.VatRateMapper;
import pl.wla.webproject.repository.VatRateRepository;
import pl.wla.webproject.repository.entities.VatRateEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VatRateService {

    @Autowired
    private VatRateRepository vatRateRepository;

    @Autowired
    private VatRateMapper vatRateMapper;


public List<VatRate> getVatRates(){
    List<VatRateEntity> vatRateEntity = vatRateRepository.findAll();
    return vatRateEntity.stream().map(vatRateMapper::entityToDomain).collect(Collectors.toList());
}
}
