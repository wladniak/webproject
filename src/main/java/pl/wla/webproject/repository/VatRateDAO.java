package pl.wla.webproject.repository;

import pl.wla.webproject.repository.entities.VatRateEntity;

import java.util.List;

public interface VatRateDAO {
    void save(final VatRateEntity vatRate);

    VatRateEntity findByCode(final String code);

    List<VatRateEntity> findAll();

    List<VatRateEntity> findByRate(final int rate);

    void delete(final VatRateEntity vatRate);

    void update(final VatRateEntity vatRateEntity);

    void updateRateByCode(final String code, final int rate);
}
