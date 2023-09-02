package com.spring6mvcrest.spring6mvcrest.mappers;

import com.spring6mvcrest.spring6mvcrest.entities.Customer;
import com.spring6mvcrest.spring6mvcrest.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDto(Customer customer);
}
