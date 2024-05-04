package rest;

import de.dhbw.softwareengineering.writingorganizer.application.AccountService;
import de.dhbw.softwareengineering.writingorganizer.adapters.account.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InputController {

    @Autowired
    AccountService service;

	@GetMapping("/account/getAllAccount/{user}")
    public ResponseEntity<List<AccountDto>> getAllAccount(user) {
        return ResponseEntity.ok(service.getAllAccount(user));
    }

    @GetMapping("/account/getAccount/{user}/{iban}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable User user, @PathVariable String iban) {

        Optional<AccountDto> account = service.getAccount(user, iban);

        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/account/createAccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto dto) {

        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/account/updateAccount")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto dto) {

        try {
            return ResponseEntity.ok(service.update(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/account/deleteAccount/{user}/{iban}")
    public void deleteAccount(@PathVariable User user, @PathVariable String iban) {
        service.delete(user, iban);
    }
}
