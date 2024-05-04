package adapter.ToDto;

import adapter.dto.*;
import domain.entity.BankAccountEntity;
import domain.entity.MasterDataEntity;
import domain.entity.TransactionsEnity;
import domain.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class UserEntityToDtoMapper {

    public UserDto mapEntityToDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setVName(entity.getVName());
        dto.setLName(entity.getLName());
        dto.setVEmail(entity.getVEmail());
        dto.setAddress(mapMasterDataEntityToDto(entity.getAddress()));
        dto.setAccounts((ArrayList<BankAccountDto>) entity.getAccounts().stream()
                .map(this::mapBankAccountEntityToDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private MasterDataDto mapMasterDataEntityToDto(MasterDataEntity entity) {
        MasterDataDto dto = new MasterDataDto();
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZip(entity.getZip());
        return dto;
    }

    private BankAccountDto mapBankAccountEntityToDto(BankAccountEntity entity) {
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

    private TransactionsDto mapTransactionEntityToDto(TransactionsEnity entity) {
        TransactionsDto dto = new TransactionsDto();
        dto.setDateTime(entity.getDateTime());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        dto.setParticulars(entity.getParticulars());
        dto.setPositiv(entity.isPositiv());
        return dto;
    }
}
