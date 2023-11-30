package pl.wla.webproject.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.wla.webproject.domain.VatRate;
import pl.wla.webproject.domain.service.CustomerService;
import pl.wla.webproject.domain.service.InvoiceService;
import pl.wla.webproject.domain.service.VatRateService;
import pl.wla.webproject.rest.dto.CustomerDTO;
import pl.wla.webproject.rest.dto.InvalidDataException;
import pl.wla.webproject.rest.dto.InvoiceDTO;
import pl.wla.webproject.rest.dto.VatRateDTO;
import pl.wla.webproject.rest.mapper.ControlerDTOToDomainMapper;
import pl.wla.webproject.rest.mapper.DomainToControlerDTOMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebController {


    private final VatRateService vatRateService;

    private final CustomerService customerService;

    private final InvoiceService invoiceService;

    private final DomainToControlerDTOMapper domainToControlerDTO;

    private final ControlerDTOToDomainMapper controlerDTOToDomain;

    private final Environment environementSettings;


    @Autowired
    @Qualifier("domainToControlerDTOMapperImpl")


    @GetMapping("/properties")
    public String getProperties() {
        String setting1 = environementSettings.getProperty("moje.property");
        String setting2 = environementSettings.getProperty("moje.property2");
        return "ala ma kota" + setting1 + " " + setting2;
    }

    @GetMapping("/getVatRates")
    public List<VatRateDTO> getVat() {
        return vatRateService.getVatRates().stream().map(domainToControlerDTO::mapVat).collect(Collectors.toList());
    }

    @GetMapping("/getVatRate/{code}")
    public VatRateDTO getVatDetails(@PathVariable String code) {
        VatRate vatRate = vatRateService.getVatDetails(code);
        VatRateDTO res = domainToControlerDTO.mapVat(vatRate);

        if (res == null) {
            throw new InvalidDataException("VAT code " + code + " not found");
        } else {
            return res;
        }
    }

    @GetMapping("/getVatCode/{rate}")
    public List<VatRateDTO> getVatDetails(@PathVariable int rate) {

        List<VatRateDTO> res = vatRateService.getVatListByRate(rate).stream().map(domainToControlerDTO::mapVat).collect(Collectors.toList());

        if (res == null) {
            throw new InvalidDataException("VAT rate " + rate + " not found");
        } else {
            return res;
        }
    }
    @PostMapping("/addVatRate")
    public HttpStatus addVatDetails(@RequestBody VatRateDTO vatRate) {
        vatRateService.addVatRate(controlerDTOToDomain.mapVat(vatRate));
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delVatRate/{code}")
    public HttpStatus deleteVatRate(@PathVariable String code) {
        vatRateService.deleteVatRate(code);
        return HttpStatus.OK;
    }

    @GetMapping("/getCustomers")
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers().stream().map(domainToControlerDTO::mapCustomer).collect(Collectors.toList());
    }

    @GetMapping("/getCustomer/{id}")
    public List<CustomerDTO> getCustomerDetails(@PathVariable int id) {
        return customerService.getCustomerDetails(id).stream().map(domainToControlerDTO::mapCustomer).collect(Collectors.toList());
    }

    @PostMapping("/addCustomer")
    public HttpStatus addCustomer(@RequestBody CustomerDTO customer) {
        customerService.addCustomer(controlerDTOToDomain.mapCustomer(customer));
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delCustomer/{id}")
    public HttpStatus deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return HttpStatus.OK;
    }

    @GetMapping("/getInvoices")
    public List<InvoiceDTO> getInvoices() {
        return invoiceService.getInvoices().stream().map(domainToControlerDTO::mapInvoice).collect(Collectors.toList());
    }

    @GetMapping("/getInvoice/{id}")
    public List<InvoiceDTO> getInvoiceDetails(@PathVariable int id) {
        return invoiceService.getInvoiceDetails(id).stream().map(domainToControlerDTO::mapInvoice).collect(Collectors.toList());
    }

    @PostMapping(path = "/addInvoice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addInvoice(@RequestBody InvoiceDTO invoice) {

        invoiceService.addInvoice(controlerDTOToDomain.mapInvoice(invoice));
        return HttpStatus.OK;

    }

    @DeleteMapping("/delInvoice/{id}")
    public HttpStatus deleteInvoice(@PathVariable int id) {
        invoiceService.deleteInvoice(id);
        return HttpStatus.OK;
    }


}