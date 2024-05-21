package de.dhbw.softwareengineering.financeplaner.plugins.persistence.repositoryimpl;

import de.dhbw.softwareengineering.financeplaner.domain.entity.UserEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.UserRepository;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper.UserEntityToJpaMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper.UserJpaToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.UserJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserImpl implements UserRepository {

    @Autowired
    private UserJpaRepository jpaRepository;

    @Autowired
    private UserJpaToEntityMapper jpaToEntityMapper;

    @Autowired
    private UserEntityToJpaMapper entityToJpaMapper;

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> entities = new ArrayList<>();

        List<UserJPA> jpas = jpaRepository.findAll();

        jpas.forEach(jpa -> {
            entities.add(jpaToEntityMapper.mapJpaToEntity(jpa));
        });

        return entities;
    }

    @Override
    public Optional<UserEntity> findByEmail(String vEmail) {
        Optional<UserJPA> jpaOptional = jpaRepository.findById(vEmail);

        return jpaOptional.map(jpa -> jpaToEntityMapper.mapJpaToEntity(jpa));
    }

    @Override
    public UserEntity create(UserEntity entity) throws Exception {
        UserJPA jpa = entityToJpaMapper.mapEntityToJpa(entity);
        UserJPA savedJpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(savedJpa);
    }

    @Override
    public UserEntity update(UserEntity entity) throws Exception {
        UserJPA jpa = entityToJpaMapper.mapEntityToJpa(entity);
        UserJPA updatedJpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(updatedJpa);
    }

    @Override
    public void deleteByEmail(String vEmail) {
        Optional<UserJPA> jpaOptional = jpaRepository.findById(vEmail);

        jpaOptional.ifPresent(jpa -> jpaRepository.delete(jpa));
    }
}