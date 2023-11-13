package pl.wla.webproject.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wla.webproject.domain.service.VatRateService;
import pl.wla.webproject.rest.dto.VatRateDTO;
import pl.wla.webproject.rest.mapper.VatRateMapperRest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class webController {

    @Autowired
    private VatRateService vatRateService;

    @Autowired
    VatRateMapperRest vatRateMapperRest;
    @GetMapping("/getVatRates")
    public List<VatRateDTO> getVat(){
        return vatRateService.getVatRates().stream().map(vatRateMapperRest::domainToControlerDTO).collect(Collectors.toList());
    }



}