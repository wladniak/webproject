package pl.wla.webproject.domain.service;

import pl.wla.webproject.domain.VatRate;

import java.util.List;

public interface VatRateService {
    List<VatRate> getVatListByRate(final int rate);

    VatRate getVatDetails(final String code);

    void addVatRate(final VatRate vatRate);

    void deleteVatRate(final String code);
}
