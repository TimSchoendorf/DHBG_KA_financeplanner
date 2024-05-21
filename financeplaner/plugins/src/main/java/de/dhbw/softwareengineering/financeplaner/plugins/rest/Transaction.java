package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.TransactionsDto;
import de.dhbw.softwareengineering.financeplaner.application.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Transaction {

    @Autowired
    TransactionService service;

    @GetMapping("/transaction/getAllTransaction/{email}")
    public ResponseEntity<List<TransactionsDto>> getAllTransactionsByEmail(String email) {
        return ResponseEntity.ok(service.getAllTransactionsByEmail(email));
    }

    @GetMapping("/transaction/getTransaction/{id}")
    public ResponseEntity<TransactionsDto> getTransaction(@PathVariable String id) {

        Optional<TransactionsDto> transaction = service.getTransactions(id);

        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/z_helper.Transaction/createTransaction")
    public ResponseEntity<TransactionsDto> createTransaction(@RequestBody TransactionsDto dto) {

        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/transaction/updateTransaction")
    public ResponseEntity<TransactionsDto> updateTransaction(@RequestBody TransactionsDto dto) {

        try {
            return ResponseEntity.ok(service.update(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/transaction/deleteTransaction/{user}/{bankaccount}/{datetime}")
    public void deleteTransaction(@PathVariable String id) {
        service.delete(id);
    }
}
