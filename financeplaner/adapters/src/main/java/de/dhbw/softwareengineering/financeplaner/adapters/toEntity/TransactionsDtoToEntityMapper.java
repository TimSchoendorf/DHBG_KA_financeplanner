package de.dhbw.softwareengineering.financeplaner.adapters.toEntity;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.TransactionsDto;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionsDtoToEntityMapper {

    public TransactionsEntity mapDtoToEntity(TransactionsDto dto) {
        TransactionsEntity entity = new TransactionsEntity();
        entity.setDateTime(dto.getDateTime());
        entity.setAmount(dto.getAmount());
        entity.setDescription(dto.getDescription());
        entity.setParticulars(dto.getParticulars());
        entity.setPositiv(dto.isPositiv());
        return entity;
    }
}
