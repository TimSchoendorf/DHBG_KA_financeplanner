package de.dhbw.softwareengineering.financeplaner.domain.repository;

import de.dhbw.softwareengineering.financeplaner.domain.Category;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import java.util.List;
import java.util.Optional;

public interface TransactionsRepository {

    // Find all transactions stored in the database
    List<TransactionsEntity> findAll();

    // Find transactions by category
    List<TransactionsEntity> findByCategory(Category category);

    // Find a specific transaction by its ID (assuming an ID field is added)
    Optional<TransactionsEntity> findById(String id);

    // Create a new transaction in the database
    TransactionsEntity create(TransactionsEntity entity) throws Exception;

    // Update an existing transaction in the database
    TransactionsEntity update(TransactionsEntity entity) throws Exception;

    List<TransactionsEntity> findByEmail(String email);

    // Delete a transaction from the database using its ID
    void deleteById(String id);

    
}
