package com.postgresspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresspring.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
