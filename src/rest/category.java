package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.writingorganizer.application.CategoryService;
import de.dhbw.softwareengineering.writingorganizer.adapters.category.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InputController {

    @Autowired
    CategoryService service;

    @GetMapping("/category/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return ResponseEntity.ok(service.getAllCategory());
    }
}
