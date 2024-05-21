package de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository;

import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.MasterDataJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterDataJpaRepository extends JpaRepository<MasterDataJPA, String> {
}
