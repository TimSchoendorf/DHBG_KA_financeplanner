package de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.BankAccountEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.BankAccountJPA;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jparepository.BankAccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountEntityToJpaMapper {

    @Autowired
    BankAccountJpaRepository bankAccountJpaRepository;

    public BankAccountJPA mapEntityToJpa(BankAccountEntity entity) throws Exception {
        checkEntityValidity(entity);
        BankAccountJPA jpa = fetchOrCreateJpa(entity);
        mapDetailsToJpa(entity, jpa);
        return jpa;
    }

    private void checkEntityValidity(BankAccountEntity entity) throws Exception {
        if (entity == null) {
            throw new IllegalArgumentException("Bank account entity cannot be null.");
        }
        if (entity.getIban() == null || entity.getIban().isEmpty()) {
            throw new IllegalArgumentException("IBAN cannot be empty.");
        }
    }

    private BankAccountJPA fetchOrCreateJpa(BankAccountEntity entity) {
        return bankAccountJpaRepository.findById(entity.getIban())
                .orElse(new BankAccountJPA());
    }

    private void mapDetailsToJpa(BankAccountEntity entity, BankAccountJPA jpa) {
        jpa.setAccountNumber(entity.getAccountNumber());
        jpa.setBankCode(entity.getBankCode());
        jpa.setCheckDigit(entity.getCheckDigit());
        jpa.setCountryCode(entity.getCountryCode());
        jpa.setIban(entity.getIban());
        jpa.setAccountType(entity.getAccountType());
        jpa.setDummyBalance(entity.getDummyBalance());
    }
}