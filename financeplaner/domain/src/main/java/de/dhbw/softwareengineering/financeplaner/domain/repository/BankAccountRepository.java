package de.dhbw.softwareengineering.financeplaner.domain.repository;

import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository {

    // Find all bank accounts stored in the database
    List<BankAccountEntity> findAll();

    // Find a bank account by its IBAN
    Optional<BankAccountEntity> findByIban(String iban);


    // Create a new bank account in the database
    BankAccountEntity create(BankAccountEntity entity) throws Exception;

    // Update an existing bank account in the database
    BankAccountEntity update(BankAccountEntity entity) throws Exception;

    // Delete a bank account from the database using its IBAN
    void deleteByIban(String iban);
}

