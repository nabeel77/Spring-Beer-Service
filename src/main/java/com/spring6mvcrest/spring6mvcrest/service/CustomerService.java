package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomer();
    Optional<Customer> getCustomerById(UUID id);
    Customer saveNewCustomer(Customer customer);

    void updatedCustomerById(UUID customerId, Customer customer);

    void deleteCustomerById(UUID customerId);

    void updatedCustomerPatchById(UUID customerId, Customer customer);
}
