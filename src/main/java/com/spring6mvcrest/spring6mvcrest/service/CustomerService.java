package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomer();
    Customer getCustomerById(UUID id);
    Customer saveNewCustomer(Customer customer);

    void updatedCustomerById(UUID customerId, Customer customer);
}
