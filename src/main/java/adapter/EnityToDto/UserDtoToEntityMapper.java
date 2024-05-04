package adapter.EnityToDto;
import domain.entity.*;
import adapter.dto.*;
//import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;
public class UserDtoToEntityMapper {
    public UserEntity mapDtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setVName(dto.getVName());
        entity.setLName(dto.getLName());
        entity.setVEmail(dto.getVEmail());
        entity.setAddress(mapMasterDataDtoToEntity(dto.getAddress()));
        entity.setAccounts((ArrayList<BankAccountEntity>) dto.getAccounts().stream()
                .map(this::mapBankAccountDtoToEntity)
                .collect(Collectors.toList()));
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
