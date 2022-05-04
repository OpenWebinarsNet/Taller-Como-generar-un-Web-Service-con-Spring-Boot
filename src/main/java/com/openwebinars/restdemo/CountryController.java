package com.openwebinars.restdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository repository;

    @GetMapping("/country")
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<Country> getByCode(@PathVariable String code) {
        return ResponseEntity.of(repository.findCountry(code));
    }

    @PostMapping("/country")
    public ResponseEntity<Country> newCountry(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.addCountry(country));
    }


}
