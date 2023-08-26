package com.spring6mvcrest.spring6mvcrest.service;

import com.spring6mvcrest.spring6mvcrest.model.BeerDTO;
import com.spring6mvcrest.spring6mvcrest.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j // for logging by project lombok
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();
        BeerDTO beer1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Corona")
                .beerStyle(BeerStyle.WHEAT)
                .upc("123456")
                .price(new BigDecimal("5.6"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        BeerDTO beer2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Spona")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("178456")
                .price(new BigDecimal("5.6"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        BeerDTO beer3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Lona")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("125456")
                .price(new BigDecimal("5.6"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<BeerDTO> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        log.debug("Get beer id in service was called");
        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        BeerDTO savedBeer = BeerDTO.builder()
                                .id(UUID.randomUUID())
                                .createdDate(LocalDateTime.now())
                                .updatedDate(LocalDateTime.now())
                                .beerName(beer.getBeerName())
                                .quantityOnHand(beer.getQuantityOnHand())
                                .upc(beer.getUpc())
                                .price(beer.getPrice())
                                .version(beer.getVersion())
                                .build();
        beerMap.put(savedBeer.getId(), savedBeer);
        return savedBeer;
    }

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beer) {
        BeerDTO existing = beerMap.get(beerId);
        existing.setBeerName(beer.getBeerName());
        existing.setPrice(beer.getPrice());
        existing.setUpc(beer.getUpc());
        existing.setQuantityOnHand(beer.getQuantityOnHand());
        existing.setUpdatedDate(LocalDateTime.now());

        beerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteBuId(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerId(UUID beerId, BeerDTO beer) {
        BeerDTO existingBeer = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getBeerName())) {
            existingBeer.setBeerName(beer.getBeerName());
        }

        if (beer.getBeerStyle() != null) {
            existingBeer.setBeerStyle(beer.getBeerStyle());
        }

        if (beer.getPrice() != null) {
            existingBeer.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null) {
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existingBeer.setUpc(beer.getUpc());
        }

        existingBeer.setUpdatedDate(LocalDateTime.now());
    }
}
