package de.dhbw.softwareengineering.financeplaner.application;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.MasterDataDto;
import de.dhbw.softwareengineering.financeplaner.adapters.toDto.MasterDataEntityToDtoMapper;
import de.dhbw.softwareengineering.financeplaner.adapters.toEntity.MasterDataDtoToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.MasterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MasterDataService {

    @Autowired
    private MasterDataRepository repository;

    @Autowired
    private MasterDataEntityToDtoMapper entityToDtoMapper;

    @Autowired
    private MasterDataDtoToEntityMapper dtoToEntityMapper;

    public List<MasterDataDto> getAllMasterData() {
        List<MasterDataDto> dtos = new ArrayList<>();
        repository.findAll().forEach(entity -> dtos.add(entityToDtoMapper.mapEntityToDto(entity)));

        return dtos;
    }

    public Optional<MasterDataDto> getMasterData(String zip) {
        Optional<MasterDataEntity> entityOptional= repository.findByZip(zip);

        return entityOptional.map(entity -> entityToDtoMapper.mapEntityToDto(entity));
    }

    public MasterDataDto create(MasterDataDto dto) throws Exception {
        MasterDataEntity entity = repository.create(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public MasterDataDto update(MasterDataDto dto) throws Exception {
        MasterDataEntity entity = repository.update(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public void delete(String zip) {repository.deleteByZip(zip);
    }
}
