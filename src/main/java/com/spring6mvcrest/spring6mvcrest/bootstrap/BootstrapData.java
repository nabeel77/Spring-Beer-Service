package com.spring6mvcrest.spring6mvcrest.bootstrap;

import com.spring6mvcrest.spring6mvcrest.entities.Beer;
import com.spring6mvcrest.spring6mvcrest.entities.Customer;
import com.spring6mvcrest.spring6mvcrest.model.BeerDTO;
import com.spring6mvcrest.spring6mvcrest.model.BeerStyle;
import com.spring6mvcrest.spring6mvcrest.model.CustomerDTO;
import com.spring6mvcrest.spring6mvcrest.repositories.BeerRepository;
import com.spring6mvcrest.spring6mvcrest.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder()
                    .beerName("Corona")
                    .beerStyle(BeerStyle.WHEAT)
                    .upc("123456")
                    .price(new BigDecimal("5.6"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();
            Beer beer2 = Beer.builder()
                    .beerName("Spona")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("178456")
                    .price(new BigDecimal("5.6"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();
            Beer beer3 = Beer.builder()
                    .beerName("Lona")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("125456")
                    .price(new BigDecimal("5.6"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            beerRepository.saveAll(Arrays.asList(beer1, beer2, beer3));
        }
    }

    private void loadCustomerData() {
        if (customerRepository.count() == 0) {
            Customer customer1 = Customer.builder()
                    .customerName("Nial")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .customerName("Cindy")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .customerName("Angela")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }
    }
}
