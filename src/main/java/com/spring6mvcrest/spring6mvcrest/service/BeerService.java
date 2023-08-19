package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Optional<Beer> getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteBuId(UUID beerId);

    void patchBeerId(UUID beerId, Beer beer);
}
