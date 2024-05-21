package de.dhbw.softwareengineering.financeplaner.adapters.toDto;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.BankAccountDto;
import de.dhbw.softwareengineering.financeplaner.adapters.dto.TransactionsDto;
import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class BankAccountEntityToDtoMapper {

    public BankAccountDto mapEntityToDto(BankAccountEntity entity) {
        BankAccountDto dto = new BankAccountDto();
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setBankCode(entity.getBankCode());
        dto.setCheckDigit(entity.getCheckDigit());
        dto.setCountryCode(entity.getCountryCode());
        dto.setIban(entity.getIban());
        dto.setAccountType(entity.getAccountType());
        dto.setDummyBalance(entity.getDummyBalance());
        dto.setTransactions((ArrayList<TransactionsDto>) entity.getTransactions().stream()
                .map(this::mapTransactionEntityToDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private TransactionsDto mapTransactionEntityToDto(TransactionsEntity entity) {
        TransactionsDto dto = new TransactionsDto();
        dto.setDateTime(entity.getDateTime());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        dto.setParticulars(entity.getParticulars());
        dto.setPositiv(entity.isPositiv());
        return dto;
    }
}
