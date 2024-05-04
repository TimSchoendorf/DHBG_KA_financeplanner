package application;

import adapter.dto.BankAccountDto;
import adapters.bankaccount.BankAccountEntityToDtoMapper;
import adapters.bankaccount.BankAccountDtoToEntityMapper;
import domain.entity.BankAccountEntity;
import domain.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    @Autowired
    private BankAccountEntityToDtoMapper entityToDtoMapper;

    @Autowired
    private BankAccountDtoToEntityMapper dtoToEntityMapper;

    public List<BankAccountDto> getAllBankAccount() {
        List<BankAccountDto> dtos = new ArrayList<>();
        repository.findAll().forEach(entity -> dtos.add(entityToDtoMapper.mapEntityToDto(entity)));

        return dtos;
    }

    public Optional<BankAccountDtoDto> getBankAccount(String user, String iban) {
        Optional<BankAccountEntity> entityOptional= repository.findById(user, iban);

        return entityOptional.map(entity -> entityToDtoMapper.mapEntityToDto(entity));
    }

    public BankAccountDto create(BankAccountDto dto) throws Exception {
        BankAccountEntity entity = repository.create(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public BankAccountDto update(BankAccountDto dto) throws Exception {
        BankAccountEntity entity = repository.update(dtoToEntityMapper.mapDtoToEntity(dto));

        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public void delete(String user, String iban) {repository.delete(user, iban);
    }
}
