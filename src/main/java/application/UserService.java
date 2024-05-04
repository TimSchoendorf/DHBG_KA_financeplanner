package application;

import adapter.dto.UserDto;
import adapters.user.UserEntityToDtoMapper;
import adapters.user.UserDtoToEntityMapper;
import domain.entity.UserEntity;
import domain.repository.UserRepository;
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

    public Optional<UserDtoDto> getUser(String email) {
        Optional<UserEntity> entityOptional= repository.findById(email);

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

    public void delete(String email) {repository.delete(email);
    }
}
