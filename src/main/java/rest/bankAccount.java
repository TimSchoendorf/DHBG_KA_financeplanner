package rest;

import de.dhbw.softwareengineering.writingorganizer.application.BankAccountService;
import de.dhbw.softwareengineering.writingorganizer.adapters.bankaccount.BankAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankAccount {

    @Autowired
    BankAccountService service;

	@GetMapping("/bankaccount/getAllBankAccount/{user}")
    public ResponseEntity<List<BankAccountDto>> getAllBankAccount(user) {
        return ResponseEntity.ok(service.getAllBankAccount(user));
    }

    @GetMapping("/bankaccount/getBankAccount/{user}/{iban}")
    public ResponseEntity<BankAccountDto> getBankAccount(@PathVariable User user, @PathVariable String iban) {

        Optional<BankAccountDto> bankaccount = service.getBankAccount(user, iban);

        return bankaccount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/bankaccount/createBankAccount")
    public ResponseEntity<BankAccountDto> createBankAccount(@RequestBody BankAccountDto dto) {

        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/bankaccount/updateBankAccount")
    public ResponseEntity<BankAccountDto> updateBankAccount(@RequestBody BankAccountDto dto) {

        try {
            return ResponseEntity.ok(service.update(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/bankaccount/deleteBankAccount/{user}/{iban}")
    public void deleteBankAccount(@PathVariable User user, @PathVariable String iban) {
        service.delete(user, iban);
    }
}
