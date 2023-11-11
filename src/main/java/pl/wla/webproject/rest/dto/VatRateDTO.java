package pl.wla.webproject.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VatRateDTO {
    private String code;
    private int vatRate;
    private String vatRateStr;

}
