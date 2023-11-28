package pl.wla.webproject.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.Customer;
import pl.wla.webproject.domain.mapper.DomainToEntityMapper;
import pl.wla.webproject.domain.mapper.EntityToDomainMapper;
import pl.wla.webproject.repository.CustomerRepository;
import pl.wla.webproject.repository.entities.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Lazy
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final EntityToDomainMapper entityToDomainMapper;

    private final DomainToEntityMapper domainToEntityMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, EntityToDomainMapper entityToDomainMapper, DomainToEntityMapper domainToEntityMapper) {
        this.customerRepository = customerRepository;
        this.entityToDomainMapper = entityToDomainMapper;
        this.domainToEntityMapper = domainToEntityMapper;
    }

    public List<Customer> getCustomers() {
        List<CustomerEntity> customerEntity = customerRepository.findAll();
        return customerEntity.stream().map(entityToDomainMapper::mapCustomer).collect(Collectors.toList());
    }

    public List<Customer> getCustomerDetails(final int id) {
        List<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.stream().map(entityToDomainMapper::mapCustomer).collect(Collectors.toList());
    }

    public void addCustomer(final Customer customer) {
        customerRepository.save(domainToEntityMapper.mapCustomer(customer));
    }

    public void deleteCustomer(final int id) {
        List<CustomerEntity> customerEntity = customerRepository.findById(id);

        for (CustomerEntity c : customerEntity) {
            customerRepository.delete(c);
        }
    }

}
