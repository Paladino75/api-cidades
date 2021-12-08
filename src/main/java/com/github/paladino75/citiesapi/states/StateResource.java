package com.github.paladino75.citiesapi.states;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// criando recurso pra chamar todas os Estados 
@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    //Get pra chamar todas os estados
    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }

    //Get para chamar os estados por ID
    @GetMapping("/{id}")
    public ResponseEntity <State> getIdState(@PathVariable Long id) {
        Optional<State> optionalState = repository.findById(id);

        if (optionalState.isPresent()) {
            return ResponseEntity.ok().body(optionalState.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
