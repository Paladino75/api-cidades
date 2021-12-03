package com.github.paladino75.citiesapi.countries;

import com.github.paladino75.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
