package de.dhbw.softwareengineering.financeplaner.plugins.persistence.EntityToJpaMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.MasterDataJPA;
import org.springframework.stereotype.Component;

@Component
public class MasterDataEntityToJpaMapper {

    public MasterDataJPA mapEntityToJpa(MasterDataEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Master data entity cannot be null");
        }

        MasterDataJPA jpa = new MasterDataJPA();
        jpa.setStreet(entity.getStreet());
        jpa.setCity(entity.getCity());
        jpa.setState(entity.getState());
        jpa.setZip(entity.getZip());

        return jpa;
    }
}