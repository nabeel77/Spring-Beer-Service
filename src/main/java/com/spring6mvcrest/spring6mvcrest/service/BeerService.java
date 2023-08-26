package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    void updateBeerById(UUID beerId, BeerDTO beer);

    void deleteBuId(UUID beerId);

    void patchBeerId(UUID beerId, BeerDTO beer);
}
