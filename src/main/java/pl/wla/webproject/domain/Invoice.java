package pl.wla.webproject.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class Invoice {
    private int invNo;
    private Date invDate;
    private Customer customer;
    private List<InvoicePosition> positions;
}
