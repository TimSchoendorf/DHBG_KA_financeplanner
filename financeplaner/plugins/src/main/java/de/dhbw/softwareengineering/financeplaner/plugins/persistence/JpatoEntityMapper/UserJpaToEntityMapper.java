package de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.UserEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.UserJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.BankAccountJpaRepository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserJpaToEntityMapper {

    private final BankAccountJpaRepository bankAccountJpaRepository;

    public UserJpaToEntityMapper(BankAccountJpaRepository bankAccountJpaRepository) {
        this.bankAccountJpaRepository = bankAccountJpaRepository;
    }

    /**
     * Maps a UserJPA object to a UserEntity object.
     *
     * @param jpa The source UserJPA object.
     * @return A new instance of UserEntity filled with values from the source object.
     */
    public UserEntity mapJpaToEntity(UserJPA jpa) {
        if (jpa == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setvName(jpa.getvName());
        entity.setlName(jpa.getlName());
        entity.setvEmail(jpa.getvEmail());

        return entity;
    }

}