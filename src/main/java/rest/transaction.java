package rest;

import de.dhbw.softwareengineering.writingorganizer.application.TransactionService;
import de.dhbw.softwareengineering.writingorganizer.adapters.transaction.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InputController {

    @Autowired
    TransactionService service;

    @GetMapping("/transaction/getAllTransaction/{user}")
    public ResponseEntity<List<TransactionDto>> getAllTransaction(user) {
        return ResponseEntity.ok(service.getAllTransaction(user));
    }

    @GetMapping("/transaction/getTransaction/{user}/{bankaccount}/{datetime}")
    public ResponseEntity<TransactionDto> getTransaction(@PathVariable User user, @PathVariable BankAccount bankaccount, @PathVariable String datetime) {

        Optional<TransactionDto> transaction = service.getTransaction(user, bankaccount, datetime);

        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Transaction/createTransaction")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto dto) {

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
    public ResponseEntity<TransactionDto> updateTransaction(@RequestBody TransactionDto dto) {

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
    public void deleteTransaction(@PathVariable User user, @PathVariable BankAccount bankaccount, @PathVariable String datetime) {
        service.delete(user, bankaccount, datetime);
    }
}
