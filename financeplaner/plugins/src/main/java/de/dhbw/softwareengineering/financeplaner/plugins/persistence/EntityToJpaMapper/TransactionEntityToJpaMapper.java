package de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.TransactionJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityToJpaMapper {

    @Autowired
    TransactionJpaRepository transactionJpaRepository;

    private void checkIfInputIsLegit(TransactionsEntity entity) throws Exception {
        if (entity.getDescription() == null || entity.getDescription().isEmpty()) {
            throw new Exception("Transaction description cannot be empty.");
        }
        if (entity.getAmount() == 0) {
            throw new Exception("Transaction amount cannot be zero.");
        }
    }

    public TransactionJPA mapEntityToJpa(TransactionsEntity entity, boolean isNewJpa) throws Exception {
        TransactionJPA jpa;
        if (isNewJpa) {
            jpa = new TransactionJPA();
        } else {
            jpa = transactionJpaRepository.findById(entity.getId())
                    .orElseThrow(() -> new Exception("Transaction not found with ID: " + entity.getId()));
        }

        jpa.setDateTime(entity.getDateTime());
        jpa.setAmount(entity.getAmount());
        jpa.setDescription(entity.getDescription());
        jpa.setParticulars(entity.getParticulars());
        jpa.setComment(entity.getComment());
        jpa.setCategory(entity.getCategory());
        jpa.setPositiv(entity.isPositiv());

        return jpa;
    }
}