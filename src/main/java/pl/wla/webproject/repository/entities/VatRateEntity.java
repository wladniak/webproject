package pl.wla.webproject.repository.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name ="VAT_RATE")
public class VatRateEntity {
    @Id
    @Column(name="VAT_CODE", length = 10)
    private String code;
    @Column(name="VAT_RATE")
    private int rate;

}
