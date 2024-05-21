package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.BankAccountDto;
import de.dhbw.softwareengineering.financeplaner.application.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class bankAccount {

    @Autowired
    BankAccountService service;

	@GetMapping("/bankaccount/getAllBankAccount")
    public ResponseEntity<List<BankAccountDto>> getAllBankAccount() {
        return ResponseEntity.ok(service.getAllBankAccount());
    }

    @GetMapping("/bankaccount/getBankAccount/{email}/{iban}")
    public ResponseEntity<BankAccountDto> getBankAccount(@PathVariable String email, @PathVariable String iban) {

        Optional<BankAccountDto> bankaccount = service.getBankAccount(email, iban);

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

    @DeleteMapping("/bankaccount/deleteBankAccount/{email}/{iban}")
    public void deleteBankAccount(@PathVariable String email, @PathVariable String iban) {
        service.delete(email, iban);
    }
}
