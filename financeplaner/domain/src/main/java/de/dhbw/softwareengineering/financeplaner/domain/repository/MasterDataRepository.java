package de.dhbw.softwareengineering.financeplaner.domain.repository;

import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;

import java.util.List;
import java.util.Optional;

public interface MasterDataRepository {

    // Find all master data entries stored in the database
    List<MasterDataEntity> findAll();

    // Find master data by zip code
    Optional<MasterDataEntity> findByZip(String zip);

    // Create a new master data entry in the database
    MasterDataEntity create(MasterDataEntity entity) throws Exception;

    // Update an existing master data entry in the database
    MasterDataEntity update(MasterDataEntity entity) throws Exception;

    // Delete a master data entry from the database using its zip code
    void deleteByZip(String zip);
}
