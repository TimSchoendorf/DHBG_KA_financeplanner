package de.dhbw.softwareengineering.financeplaner.application;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.TransactionsDto;
import de.dhbw.softwareengineering.financeplaner.adapters.toDto.TransactionEntityToDtoMapper;
import de.dhbw.softwareengineering.financeplaner.adapters.toEntity.TransactionsDtoToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionsRepository repository;

    @Autowired
    private TransactionEntityToDtoMapper entityToDtoMapper;

    @Autowired
    private TransactionsDtoToEntityMapper dtoToEntityMapper;

    public List<TransactionsDto> getAllTransactionsByEmail(String email) {
        List<TransactionsDto> dtos = new ArrayList<>();
        repository.findByEmail(email).forEach(entity -> dtos.add(entityToDtoMapper.mapEntityToDto(entity)));
    
        return dtos;
    }
    
    public Optional<TransactionsDto> getTransactions(String id) {
        Optional<TransactionsEntity> entityOptional= repository.findById(id);

        return entityOptional.map(entity -> entityToDtoMapper.mapEntityToDto(entity));
    }

    public TransactionsDto create(TransactionsDto dto) throws Exception {
        TransactionsEntity entity = repository.create(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public TransactionsDto update(TransactionsDto dto) throws Exception {
        TransactionsEntity entity = repository.update(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public void delete(String id) {repository.deleteById(id);
    }
}
