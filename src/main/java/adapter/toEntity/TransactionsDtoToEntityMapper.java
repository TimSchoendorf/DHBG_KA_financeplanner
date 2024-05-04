package adapter.toEntity;

import adapter.dto.TransactionsDto;
import domain.entity.TransactionsEnity;
import org.springframework.stereotype.Component;

@Component
public class TransactionsDtoToEntityMapper {

    public TransactionsEnity mapDtoToEntity(TransactionsDto dto) {
        TransactionsEnity entity = new TransactionsEnity();
        entity.setDateTime(dto.getDateTime());
        entity.setAmount(dto.getAmount());
        entity.setDescription(dto.getDescription());
        entity.setParticulars(dto.getParticulars());
        entity.setPositiv(dto.isPositiv());
        return entity;
    }
}
