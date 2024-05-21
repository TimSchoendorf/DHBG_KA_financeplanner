package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.UserDto;
import de.dhbw.softwareengineering.financeplaner.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class User {

    @Autowired
    UserService service;

    @GetMapping("/user/getUser/{email}")
    public ResponseEntity<UserDto> getUser(@PathVariable String email) {

        Optional<UserDto> user = service.getUser(email);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/user/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {

        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (Exception exception) {
            System.out.println(exception);
            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/user/updateUser")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto) {

        try {
            return ResponseEntity.ok(service.update(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/user/deleteUser/{name}/{password}")
    public void deleteUser(@PathVariable String name, @PathVariable String email) {
        service.delete(email);
    }
}
