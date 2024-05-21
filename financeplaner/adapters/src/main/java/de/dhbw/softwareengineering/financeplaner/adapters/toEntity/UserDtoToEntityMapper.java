package de.dhbw.softwareengineering.financeplaner.adapters.toEntity;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.BankAccountDto;
import de.dhbw.softwareengineering.financeplaner.adapters.dto.MasterDataDto;
import de.dhbw.softwareengineering.financeplaner.adapters.dto.UserDto;
import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;
import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;
import de.dhbw.softwareengineering.financeplaner.domain.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class UserDtoToEntityMapper {
    public UserEntity mapDtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setvName(dto.getvName());
        entity.setlName(dto.getlName());
        entity.setvEmail(dto.getvEmail());
        return entity;
    }
    private MasterDataEntity mapMasterDataDtoToEntity(MasterDataDto dto) {
        MasterDataEntity data = new MasterDataEntity();
        data.setStreet(dto.getStreet());
        data.setCity(dto.getCity());
        data.setState(dto.getState());
        data.setZip(dto.getZip());
        return data;
    }

    private BankAccountEntity mapBankAccountDtoToEntity(BankAccountDto dto) {
        BankAccountEntity account = new BankAccountEntity();
        account.setIban(dto.getIban());
        account.setDummyBalance(dto.getDummyBalance());
        return account;
    }

}
