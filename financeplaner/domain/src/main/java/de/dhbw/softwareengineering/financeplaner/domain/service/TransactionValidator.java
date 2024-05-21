package de.dhbw.softwareengineering.financeplaner.domain.service;

import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import org.hibernate.service.Service;

public class TransactionValidator {

    public void validate(TransactionsEntity transaction) throws ValidationException {
        if (transaction == null) {
            throw new ValidationException("Transaction cannot be null");
        }
        if (transaction.getAmount() <= 0) {
            throw new ValidationException("Transaction amount must be positive");
        }
        if (transaction.getDateTime() == null) {
            throw new ValidationException("Transaction date and time cannot be null");
        }
        if (transaction.getDescription() == null || transaction.getDescription().isEmpty()) {
            throw new ValidationException("Transaction description cannot be empty");
        }
        if (transaction.getCategory() == null) {
            throw new ValidationException("Transaction category cannot be null");
        }
        // Add more validation rules as needed
    }

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}