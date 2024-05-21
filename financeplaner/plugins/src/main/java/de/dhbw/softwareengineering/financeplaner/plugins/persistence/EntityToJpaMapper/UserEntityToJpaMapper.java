package de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.UserEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.List;

@Component
public class UserEntityToJpaMapper {

    @Autowired
    private MasterDataEntityToJpaMapper masterDataMapper;
    @Autowired
    private BankAccountEntityToJpaMapper bankAccountMapper;

    public UserJPA mapEntityToJpa(UserEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("User entity cannot be null");
        }

        UserJPA jpa = new UserJPA();
        jpa.setvEmail(entity.getvEmail());
        jpa.setvName(entity.getvName());
        jpa.setlName(entity.getlName());

        return jpa;
    }
}
