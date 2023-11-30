package pl.wla.webproject.domain.service;

import pl.wla.webproject.domain.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getInvoices();

    List<Invoice> getInvoiceDetails(final int id);

    void addInvoice(final Invoice invoice);

    void deleteInvoice(final int id);
}
