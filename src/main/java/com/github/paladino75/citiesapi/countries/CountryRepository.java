package com.github.paladino75.citiesapi.countries;

import com.github.paladino75.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByName(String name);
}
