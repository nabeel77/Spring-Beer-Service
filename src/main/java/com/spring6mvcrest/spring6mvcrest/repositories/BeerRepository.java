package com.spring6mvcrest.spring6mvcrest.repositories;

import com.spring6mvcrest.spring6mvcrest.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
