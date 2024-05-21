package de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.BankAccountJPA;
import org.springframework.stereotype.Component;

@Component
public class BankAccountJpaToEntityMapper {

    public BankAccountEntity mapJpaToEntity(BankAccountJPA jpa) {
        if (jpa == null) {
            return null;
        }

        BankAccountEntity entity = new BankAccountEntity();
        entity.setIban(jpa.getIban());
        entity.setAccountNumber(jpa.getAccountNumber());
        entity.setBankCode(jpa.getBankCode());
        entity.setCheckDigit(jpa.getCheckDigit());
        entity.setCountryCode(jpa.getCountryCode());
        entity.setAccountType(jpa.getAccountType());
        entity.setDummyBalance(jpa.getDummyBalance());

        return entity;
    }
}