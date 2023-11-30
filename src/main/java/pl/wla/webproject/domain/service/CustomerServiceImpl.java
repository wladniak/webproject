package pl.wla.webproject.domain.service;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final EntityToDomainMapper entityToDomainMapper;

    private final DomainToEntityMapper domainToEntityMapper;


    @Override
    public List<Customer> getCustomers() {
        List<CustomerEntity> customerEntity = customerRepository.findAll();
        return customerEntity.stream().map(entityToDomainMapper::mapCustomer).collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomerDetails(final int id) {
        List<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.stream().map(entityToDomainMapper::mapCustomer).collect(Collectors.toList());
    }

    @Override
    public void addCustomer(final Customer customer) {
        customerRepository.save(domainToEntityMapper.mapCustomer(customer));
    }

    @Override
    public void deleteCustomer(final int id) {
        List<CustomerEntity> customerEntity = customerRepository.findById(id);

        for (CustomerEntity c : customerEntity) {
            customerRepository.delete(c);
        }
    }

}
