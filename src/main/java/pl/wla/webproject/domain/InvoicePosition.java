package pl.wla.webproject.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoicePosition {
    private int posInvNo;
    private int posNo;
    private VatRate vat;
    private float quantity;
    private float price;
    private String posDescription;
}
