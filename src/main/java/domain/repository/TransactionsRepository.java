package domain.repository;

import domain.entity.TransactionsEnity;
import z_helper.enumDefinition.Category;

import java.util.List;
import java.util.Optional;

public interface TransactionsRepository {

    // Find all transactions stored in the database
    List<TransactionsEnity> findAll();

    // Find transactions by category
    List<TransactionsEnity> findByCategory(Category category);

    // Find a specific transaction by its ID (assuming an ID field is added)
    Optional<TransactionsEnity> findById(Long id);

    // Create a new transaction in the database
    TransactionsEnity create(TransactionsEnity entity) throws Exception;

    // Update an existing transaction in the database
    TransactionsEnity update(TransactionsEnity entity) throws Exception;

    // Delete a transaction from the database using its ID
    void deleteById(Long id);
}
