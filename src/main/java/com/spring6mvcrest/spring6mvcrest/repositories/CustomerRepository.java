package com.spring6mvcrest.spring6mvcrest.repositories;

import com.spring6mvcrest.spring6mvcrest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
