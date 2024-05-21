package de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.TransactionJPA;
import org.springframework.stereotype.Component;

@Component
public class TransactionJpaToEntityMapper {

    /**
     * Maps a TransactionJPA object to a TransactionsEntity object.
     *
     * @param jpa The source TransactionJPA object.
     * @return A new instance of TransactionsEntity filled with values from the source object.
     */
    public TransactionsEntity mapJpaToEntity(TransactionJPA jpa) {
        if (jpa == null) {
            return null;
        }

        TransactionsEntity entity = new TransactionsEntity();
        entity.setDateTime(jpa.getDateTime());
        entity.setAmount(jpa.getAmount());
        entity.setDescription(jpa.getDescription());
        entity.setParticulars(jpa.getParticulars());
        entity.setComment(jpa.getComment());
        entity.setCategory(jpa.getCategory());
        entity.setPositiv(jpa.isPositiv());

        // The ID and any other unique identifiers should be managed based on the specific needs of the domain logic.
        // For example, if the ID is not directly copied from the JPA entity, it should be set accordingly elsewhere.

        return entity;
    }
}