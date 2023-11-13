package pl.wla.webproject.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wla.webproject.domain.service.CustomerService;
import pl.wla.webproject.domain.service.InvoiceService;
import pl.wla.webproject.domain.service.VatRateService;
import pl.wla.webproject.rest.dto.CustomerDTO;
import pl.wla.webproject.rest.dto.InvoiceDTO;
import pl.wla.webproject.rest.dto.VatRateDTO;
import pl.wla.webproject.rest.mapper.ControlerDTOToDomainMapper;
import pl.wla.webproject.rest.mapper.DomainToControlerDTOMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class webController {

    @Autowired
    private VatRateService vatRateService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    DomainToControlerDTOMapper domainToControlerDTO;

    @Autowired
    ControlerDTOToDomainMapper controlerDTOToDomain;
    @GetMapping("/getVatRates")
    public List<VatRateDTO> getVat(){
        return vatRateService.getVatRates().stream().map(domainToControlerDTO::mapVat).collect(Collectors.toList());
    }

    @GetMapping("/getVatRate/{code}")
    public List<VatRateDTO> getVatDetails(@PathVariable String code){
        return vatRateService.getVatDetails(code).stream().map(domainToControlerDTO::mapVat).collect(Collectors.toList());
    }

    @PostMapping("/addVatRate")
    public HttpStatus addVatDetails(@RequestBody VatRateDTO vatRate){
        vatRateService.addVatRate(controlerDTOToDomain.mapVat(vatRate));
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delVatRate/{code}")
    public HttpStatus deleteVatRate(@PathVariable String code){
        vatRateService.deleteVatRate(code);
        return HttpStatus.OK;
    }

    @GetMapping("/getCustomers")
    public List<CustomerDTO> getCustomers(){
        return customerService.getCustomers().stream().map(domainToControlerDTO::mapCustomer).collect(Collectors.toList());
    }

    @GetMapping("/getCustomer/{id}")
    public List<CustomerDTO> getCustomerDetails(@PathVariable int id){
        return customerService.getCustomerDetails(id).stream().map(domainToControlerDTO::mapCustomer).collect(Collectors.toList());
    }

    @PostMapping("/addCustomer")
    public HttpStatus addCustomer(@RequestBody CustomerDTO customer){
        customerService.addCustomer(controlerDTOToDomain.mapCustomer(customer));
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delCustomer/{id}")
    public HttpStatus deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return HttpStatus.OK;
    }

    @GetMapping("/getInvoices")
    public List<InvoiceDTO> getInvoices(){
        return invoiceService.getInvoices().stream().map(domainToControlerDTO::mapInvoice).collect(Collectors.toList());
    }

    @GetMapping("/getInvoice/{id}")
    public List<InvoiceDTO> getInvoiceDetails(@PathVariable int id){
        return invoiceService.getInvoiceDetails(id).stream().map(domainToControlerDTO::mapInvoice).collect(Collectors.toList());
    }

    @PostMapping("/addInvoice")
    public HttpStatus addInvoice(@RequestBody InvoiceDTO invoice){
        invoiceService.addInvoice(controlerDTOToDomain.mapInvoice(invoice));
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delInvoice/{id}")
    public HttpStatus deleteInvoice(@PathVariable int id){
        invoiceService.deleteInvoice(id);
        return HttpStatus.OK;
    }


}