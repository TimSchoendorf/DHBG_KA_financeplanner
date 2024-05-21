package de.dhbw.softwareengineering.financeplaner.application;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.UserDto;
import de.dhbw.softwareengineering.financeplaner.adapters.toDto.UserEntityToDtoMapper;
import de.dhbw.softwareengineering.financeplaner.adapters.toEntity.UserDtoToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.domain.entity.UserEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserEntityToDtoMapper entityToDtoMapper;

    @Autowired
    private UserDtoToEntityMapper dtoToEntityMapper;

    public List<UserDto> getAllUser() {
        List<UserDto> dtos = new ArrayList<>();
        repository.findAll().forEach(entity -> dtos.add(entityToDtoMapper.mapEntityToDto(entity)));

        return dtos;
    }

    public Optional<UserDto> getUser(String email) {
        Optional<UserEntity> entityOptional= repository.findByEmail(email);

        return entityOptional.map(entity -> entityToDtoMapper.mapEntityToDto(entity));
    }

    public UserDto create(UserDto dto) throws Exception {
        UserEntity entity = repository.create(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public UserDto update(UserDto dto) throws Exception {
        UserEntity entity = repository.update(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public void delete(String email) {repository.deleteByEmail(email);
    }
}
