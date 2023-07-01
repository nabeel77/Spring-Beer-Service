package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.Beer;
import com.spring6mvcrest.spring6mvcrest.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j // for logging by project lombok
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Get beer id in service was called");
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Corona")
                .beerStyle(BeerStyle.WHEAT)
                .upc("123456")
                .price(new BigDecimal("5.6"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
