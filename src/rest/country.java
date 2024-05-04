package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.writingorganizer.application.CountryService;
import de.dhbw.softwareengineering.writingorganizer.adapters.country.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InputController {

    @Autowired
    CountryService service;

    @GetMapping("/country/getAllCountry")
    public ResponseEntity<List<CountryDto>> getAllCountry() {
        return ResponseEntity.ok(service.getAllCounty());
    }
}
