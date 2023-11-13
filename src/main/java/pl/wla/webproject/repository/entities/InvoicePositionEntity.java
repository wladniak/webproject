package pl.wla.webproject.repository.entities;


import javax.persistence.*;

@Entity
@IdClass(InvoicePositionID.class)
@Table(name ="INVOICE_POSITION")
public class InvoicePositionEntity{
    @Id
    @Column(name="POS_INV_NO")
    private int posInvNo;
    @Id
    @Column(name="POS_NO")
    private int posNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POS_VAT_CODE", referencedColumnName = "VAT_CODE")
    private VatRateEntity vat;
    @Column(name="POS_QTY")
    private float quantity;
    @Column(name="POS_PRICE")
    private float price;
    @Column(name="POS_DESC", length = 200)
    private String posDescription;
}