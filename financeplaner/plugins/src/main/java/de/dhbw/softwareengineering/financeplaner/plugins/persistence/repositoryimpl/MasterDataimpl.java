package de.dhbw.softwareengineering.financeplaner.plugins.persistence.repositoryimpl;

import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;
import de.dhbw.softwareengineering.financeplaner.domain.repository.MasterDataRepository;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper.MasterDataEntityToJpaMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper.MasterDataJpaToEntityMapper;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.MasterDataJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.MasterDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MasterDataimpl implements MasterDataRepository {

    @Autowired
    private MasterDataJpaRepository jpaRepository;

    @Autowired
    private MasterDataJpaToEntityMapper jpaToEntityMapper;

    @Autowired
    private MasterDataEntityToJpaMapper entityToJpaMapper;

    @Override
    public List<MasterDataEntity> findAll() {
        List<MasterDataJPA> jpas = jpaRepository.findAll();
        return jpas.stream()
                .map(jpaToEntityMapper::mapJpaToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MasterDataEntity> findByZip(String zip) {
        Optional<MasterDataJPA> jpaOptional = jpaRepository.findById(zip);
        return jpaOptional.map(jpaToEntityMapper::mapJpaToEntity);
    }

    @Override
    public MasterDataEntity create(MasterDataEntity entity) throws Exception {
        MasterDataJPA jpa = entityToJpaMapper.mapEntityToJpa(entity);
        MasterDataJPA savedJpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(savedJpa);
    }

    @Override
    public MasterDataEntity update(MasterDataEntity entity) throws Exception {
        MasterDataJPA jpa = entityToJpaMapper.mapEntityToJpa(entity);
        MasterDataJPA updatedJpa = jpaRepository.save(jpa);
        return jpaToEntityMapper.mapJpaToEntity(updatedJpa);
    }

    @Override
    public void deleteByZip(String zip) {
        jpaRepository.findById(zip).ifPresent(jpaRepository::delete);
    }
}
