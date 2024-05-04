package adapter.toEntity;

import adapter.dto.MasterDataDto;
import domain.entity.MasterDataEntity;
import org.springframework.stereotype.Component;

@Component
public class MasterDataDtoToEntityMapper {

    public MasterDataEntity mapDtoToEntity(MasterDataDto dto) {
        MasterDataEntity entity = new MasterDataEntity();
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZip(dto.getZip());
        return entity;
    }
}
