package com.postgresspring.Service;

import java.util.List;

import com.postgresspring.Entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}