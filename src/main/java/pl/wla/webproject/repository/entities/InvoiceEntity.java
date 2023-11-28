package pl.wla.webproject.repository.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "INVOICE")
public class InvoiceEntity {
    @Id
    @Column(name = "INV_NO")
    private int invNo;
    @Column(name = "INV_DATE")
    @Temporal(TemporalType.DATE)
    private Date invDate;
    @OneToOne
    @JoinColumn(name = "INV_CUST_ID", referencedColumnName = "CUST_ID")
    private CustomerEntity customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POS_INV_NO", referencedColumnName = "INV_NO")
    private List<InvoicePositionEntity> positions;

}
