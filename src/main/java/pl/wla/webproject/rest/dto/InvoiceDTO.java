package pl.wla.webproject.rest.dto;

import lombok.Getter;
import lombok.Setter;
import pl.wla.webproject.domain.Customer;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class InvoiceDTO {
    private int invNo;
    private Date invDate;
    private Customer customer;
    private List<InvoicePositionDTO> positions;
}
