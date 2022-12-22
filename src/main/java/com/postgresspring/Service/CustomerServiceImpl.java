package com.postgresspring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postgresspring.Entity.Customer;
import com.postgresspring.Repository.CustomerRepository;
import com.postgresspring.Exception.CustomerNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return unwrapCustomer(customer, id);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    static Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new CustomerNotFoundException(id);
    }
}
