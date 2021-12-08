package com.github.paladino75.citiesapi.cities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
// criando recurso pra chamar todas as cidades
@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

    //Get pra chamar todas as cidades
    @GetMapping
    public Page <City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    //Get para chamar a cidade por ID
    @GetMapping("/{id}")
    public ResponseEntity<City> getIdCity(@PathVariable Long id){
        Optional<City> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
