package de.dhbw.softwareengineering.financeplaner.plugins.persistence.repositoryimpl;

import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.BankAccountRepository;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper.BankAccountEntityToJpaMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper.BankAccountJpaToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.BankAccountJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.BankAccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BankAccountimpl implements BankAccountRepository {

    @Autowired
    private BankAccountJpaRepository jpaRepository;

    @Autowired
    private BankAccountJpaToEntityMapper jpaToEntityMapper;

    @Autowired
    private BankAccountEntityToJpaMapper entityToJpaMapper;

    @Override
    public List<BankAccountEntity> findAll() {
        List<BankAccountEntity> entities = new ArrayList<>();
        List<BankAccountJPA> jpas = jpaRepository.findAll();
        jpas.forEach(jpa -> {
            entities.add(jpaToEntityMapper.mapJpaToEntity(jpa));
        });
        return entities;
    }

    @Override
    public Optional<BankAccountEntity> findByIban(String iban) {
        Optional<BankAccountJPA> jpaOptional = jpaRepository.findById(iban);
        return jpaOptional.map(jpa -> jpaToEntityMapper.mapJpaToEntity(jpa));
    }

    @Override
    public BankAccountEntity create(BankAccountEntity entity) throws Exception {
        BankAccountJPA jpa = entityToJpaMapper.mapEntityToJpa(entity);
        BankAccountJPA savedJpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(savedJpa);
    }

    @Override
    public BankAccountEntity update(BankAccountEntity entity) throws Exception {
        BankAccountJPA jpa = entityToJpaMapper.mapEntityToJpa(entity);
        BankAccountJPA updatedJpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(updatedJpa);
    }

    @Override
    public void deleteByIban(String iban) {
        jpaRepository.deleteById(iban);
    }
}