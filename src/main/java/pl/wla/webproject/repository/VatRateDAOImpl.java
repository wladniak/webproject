package pl.wla.webproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.wla.webproject.repository.entities.VatRateEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VatRateDAOImpl implements VatRateDAO {
    private final EntityManager entityManager;

    @Override
    public void delete(final VatRateEntity vatRate) {
        entityManager.remove(vatRate);
    }

    @Override
    public List<VatRateEntity> findByRate(final int rate) {
        TypedQuery<VatRateEntity> qry = entityManager.createQuery("FROM VatRateEntity WHERE rate=:vatRate order by code", VatRateEntity.class);
        qry.setParameter("vatRate", rate);
        return qry.getResultList();
    }

    @Override
    public void save(final VatRateEntity vatRate) {
        entityManager.persist(vatRate);
    }

    @Override
    public void update(final VatRateEntity vatRateEntity) {
        entityManager.merge(vatRateEntity);
    }

    @Override
    public void updateRateByCode(final String code, final int rate) {
        TypedQuery<VatRateEntity> updStm = entityManager.createQuery("UPDATE VatRateEntity set rate=:vatRate WHERE code=:vatCode", VatRateEntity.class);
        updStm.setParameter("vatCode", code);
        updStm.setParameter("vatRate", rate);
        int cnt = updStm.executeUpdate();
    }

    @Override
    public List<VatRateEntity> findAll() {
        TypedQuery<VatRateEntity> qry = entityManager.createQuery("FROM VatRateEntity order by code", VatRateEntity.class);
        return qry.getResultList();
    }

    @Override
    public VatRateEntity findByCode(final String code) {
        return entityManager.find(VatRateEntity.class, code);
    }


}


