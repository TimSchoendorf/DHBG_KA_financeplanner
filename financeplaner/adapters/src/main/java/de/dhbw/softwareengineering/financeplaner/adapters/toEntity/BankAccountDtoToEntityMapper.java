package de.dhbw.softwareengineering.financeplaner.adapters.toEntity;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.BankAccountDto;
import de.dhbw.softwareengineering.financeplaner.adapters.dto.TransactionsDto;
import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
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
        entity.setTransactions((ArrayList<TransactionsEntity>) dto.getTransactions().stream()
                .map(this::mapTransactionDtoToEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    private TransactionsEntity mapTransactionDtoToEntity(TransactionsDto dto) {
        TransactionsEntity transaction = new TransactionsEntity();
        transaction.setAmount(dto.getAmount());
        transaction.setDateTime(dto.getDateTime());
        transaction.setDescription(dto.getDescription());
        return transaction;
    }
}
