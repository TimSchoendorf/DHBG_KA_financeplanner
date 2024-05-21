package de.dhbw.softwareengineering.financeplaner.plugins.persistence.JpatoEntityMapper;

import de.dhbw.softwareengineering.financeplaner.domain.entity.MasterDataEntity;
import de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa.MasterDataJPA;
import org.springframework.stereotype.Component;

@Component
public class MasterDataJpaToEntityMapper {

    /**
     * Maps a MasterDataJPA object to a MasterDataEntity object.
     *
     * @param jpa The source MasterDataJPA object.
     * @return A new instance of MasterDataEntity filled with values from the source object.
     */
    public MasterDataEntity mapJpaToEntity(MasterDataJPA jpa) {
        if (jpa == null) {
            return null;
        }

        MasterDataEntity entity = new MasterDataEntity();
        entity.setStreet(jpa.getStreet());
        entity.setCity(jpa.getCity());
        entity.setState(jpa.getState());
        entity.setZip(jpa.getZip());

        return entity;
    }
}