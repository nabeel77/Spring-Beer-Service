package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> listCustomer();
    Optional<CustomerDTO> getCustomerById(UUID id);
    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updatedCustomerById(UUID customerId, CustomerDTO customer);

    void deleteCustomerById(UUID customerId);

    void updatedCustomerPatchById(UUID customerId, CustomerDTO customer);
}
