package adapter;

import adapter.dto.TransactionsDto;
import domain.entity.TransactionsEnity;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityToDtoMapper {

    public TransactionsDto mapEntityToDto(TransactionsEnity entity) {
        TransactionsDto dto = new TransactionsDto();
        dto.setDateTime(entity.getDateTime());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        dto.setParticulars(entity.getParticulars());
        dto.setPositiv(entity.isPositiv());
        return dto;
    }
}
