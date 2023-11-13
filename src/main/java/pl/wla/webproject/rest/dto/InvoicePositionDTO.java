package pl.wla.webproject.rest.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InvoicePositionDTO {
    private int posInvNo;
    private int posNo;
    private VatRateDTO vat;
    private float quantity;
    private float price;
    private String posDescription;
}
