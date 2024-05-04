package adapter.toEntity;

import adapter.dto.BankAccountDto;
import adapter.dto.TransactionsDto;
import domain.entity.BankAccountEntity;
import domain.entity.TransactionsEnity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class BankAccountDtoToEntityMapper {

    public BankAccountEntity mapDtoToEntity(BankAccountDto dto) {
        BankAccountEntity entity = new BankAccountEntity();
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setBankCode(dto.getBankCode());
        entity.setCheckDigit(dto.getCheckDigit());
        entity.setCountryCode(dto.getCountryCode());
        entity.setIban(dto.getIban());
        entity.setAccountType(dto.getAccountType());
        entity.setDummyBalance(dto.getDummyBalance());
        entity.setTransactions((ArrayList<TransactionsEnity>) dto.getTransactions().stream()
                .map(this::mapTransactionDtoToEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    private TransactionsEnity mapTransactionDtoToEntity(TransactionsDto dto) {
        TransactionsEnity transaction = new TransactionsEnity();
        transaction.setAmount(dto.getAmount());
        transaction.setDateTime(dto.getDateTime());
        transaction.setDescription(dto.getDescription());
        return transaction;
    }
}
