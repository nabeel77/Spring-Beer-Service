package com.spring6mvcrest.spring6mvcrest.mappers;

import com.spring6mvcrest.spring6mvcrest.entities.Beer;
import com.spring6mvcrest.spring6mvcrest.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO beerDTO);
    BeerDTO beerToBeerDTO(Beer beer);
}
