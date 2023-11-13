package pl.wla.webproject.repository.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="INVOICE")
public class InvoiceEntity {
    @Id
    @Column(name = "INV_NO")
    private int invno;
    @Column(name = "INV_DATE")
    @Temporal(TemporalType.DATE)
    private Date invDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INV_CUST_ID", referencedColumnName = "CUST_ID")
    private CustomerEntity customer;
    @OneToMany
    @JoinColumn(name = "POS_INV_NO")
    private List<InvoicePositionEntity> positions;

}
