package de.dhbw.softwareengineering.financeplaner.adapters.toDto;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.TransactionsDto;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityToDtoMapper {

    public TransactionsDto mapEntityToDto(TransactionsEntity entity) {
        TransactionsDto dto = new TransactionsDto();
        dto.setDateTime(entity.getDateTime());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        dto.setParticulars(entity.getParticulars());
        dto.setPositiv(entity.isPositiv());
        return dto;
    }
}
