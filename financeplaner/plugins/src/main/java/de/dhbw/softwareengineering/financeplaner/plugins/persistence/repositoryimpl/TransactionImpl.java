package de.dhbw.softwareengineering.financeplaner.plugins.persistence.repositoryimpl;

import de.dhbw.softwareengineering.financeplaner.domain.Category;
import de.dhbw.softwareengineering.financeplaner.domain.entity.TransactionsEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.TransactionsRepository;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper.TransactionEntityToJpaMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper.TransactionJpaToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.TransactionJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionImpl implements TransactionsRepository {

    @Autowired
    private TransactionJpaRepository jpaRepository;

    @Autowired
    private TransactionJpaToEntityMapper jpaToEntityMapper;

    @Autowired
    private TransactionEntityToJpaMapper entityToJpaMapper;

    @Override
    public List<TransactionsEntity> findAll() {
        List<TransactionsEntity> entities = new ArrayList<>();
        List<TransactionJPA> jpas = jpaRepository.findAll();

        jpas.forEach(jpa -> {
            entities.add(jpaToEntityMapper.mapJpaToEntity(jpa));
        });

        return entities;
    }

    @Override
    public List<TransactionsEntity> findByCategory(Category category) {
        return List.of();
    }

    @Override
    public Optional<TransactionsEntity> findById(String id) {
        Optional<TransactionJPA> jpaOptional = jpaRepository.findById(id);
        return jpaOptional.map(jpa -> jpaToEntityMapper.mapJpaToEntity(jpa));
    }

    @Override
    public TransactionsEntity create(TransactionsEntity entity) throws Exception {
        TransactionJPA jpa = entityToJpaMapper.mapEntityToJpa(entity, true);
        jpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(jpa);
    }

    @Override
    public TransactionsEntity update(TransactionsEntity entity) throws Exception {
        TransactionJPA jpa = entityToJpaMapper.mapEntityToJpa(entity, false);
        jpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(jpa);
    }

    @Override
    public List<TransactionsEntity> findByEmail(String email) {
        return List.of();
    }

    @Override
    public void deleteById(String id) {
        Optional<TransactionJPA> jpaOptional = jpaRepository.findById(id);
        jpaOptional.ifPresent(jpa -> jpaRepository.delete(jpa));
    }
}
