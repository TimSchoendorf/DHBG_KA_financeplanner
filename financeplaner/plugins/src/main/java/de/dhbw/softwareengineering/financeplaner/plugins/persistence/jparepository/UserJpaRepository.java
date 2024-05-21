package de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository;

import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJPA, String> {
}
