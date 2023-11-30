package pl.wla.webproject.domain.service;

import pl.wla.webproject.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    List<Customer> getCustomerDetails(final int id);

    void addCustomer(final Customer customer);

    void deleteCustomer(final int id);
}
