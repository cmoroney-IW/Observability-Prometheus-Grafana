package com.postgresspring.Service;

import java.util.List;

import com.postgresspring.Entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomerById(Long id);

    void saveCustomer(Customer customer);

    void deleteCustomer(Long id);

}