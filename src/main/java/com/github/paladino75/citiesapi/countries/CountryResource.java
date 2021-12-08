package com.github.paladino75.citiesapi.countries;

import com.github.paladino75.citiesapi.countries.Country;
import com.github.paladino75.citiesapi.countries.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// criando recurso pra chamar todas os Paises
@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    // Get pra chamar todas os Paises
    @GetMapping()
    public Page<Country> countries(Pageable page) {

        return repository.findAll(page);
    }

    //Get para chamar os paises por ID
    @GetMapping("/{name}")
    public ResponseEntity<Country> getCountry(@PathVariable String name) {
        Optional <Country> optionalCountry = repository.findByName(name);

        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok().body(optionalCountry.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
