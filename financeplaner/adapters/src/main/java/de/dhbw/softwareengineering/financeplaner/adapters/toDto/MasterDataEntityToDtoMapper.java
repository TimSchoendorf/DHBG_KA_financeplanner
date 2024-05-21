package de.dhbw.softwareengineering.financeplaner.adapters.toDto;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.MasterDataDto;
import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;
import org.springframework.stereotype.Component;

@Component
public class MasterDataEntityToDtoMapper {

    public MasterDataDto mapEntityToDto(MasterDataEntity entity) {
        MasterDataDto dto = new MasterDataDto();
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZip(entity.getZip());
        return dto;
    }
}
