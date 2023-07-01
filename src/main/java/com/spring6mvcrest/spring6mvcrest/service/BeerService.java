package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);

}
