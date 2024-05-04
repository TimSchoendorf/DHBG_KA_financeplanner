package persistence.MasterData;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Entity
@Table(name = "master_data", schema = "DHBW_Financeplanner")
public class MasterDataJPA {

    @Id
    @Column(name = "zip")
    @Getter @Setter
    private String zip;

    @Basic
    @Column(name = "street")
    @Getter @Setter
    private String street;

    @Basic
    @Column(name = "city")
    @Getter @Setter
    private String city;

    @Basic
    @Column(name = "state")
    @Getter @Setter
    private String state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterDataJPA that = (MasterDataJPA) o;
        return Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zip, that.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, zip);
    }
}
