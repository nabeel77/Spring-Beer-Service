package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.mappers.CustomerMapper;
import com.spring6mvcrest.spring6mvcrest.model.CustomerDTO;
import com.spring6mvcrest.spring6mvcrest.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceIJPA implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.ofNullable(customerMapper.customerToCustomerDto(customerRepository.findById(id).orElse(null)));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return customerMapper.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customer)));
    }

    @Override
    public void updatedCustomerById(UUID customerId, CustomerDTO customer) {
        customerRepository.findById(customerId).ifPresent(foundCustomer -> {
            foundCustomer.setCustomerName(customer.getCustomerName());
            foundCustomer.setVersion(Integer.parseInt(customer.getVersion()));
            foundCustomer.setUpdatedDate(LocalDateTime.now());
            customerRepository.save(foundCustomer);
        });
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }

    @Override
    public void updatedCustomerPatchById(UUID customerId, CustomerDTO customer) {

    }
}
