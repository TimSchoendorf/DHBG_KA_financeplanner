package de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository;

import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.BankAccountJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountJPA, String> {

}
