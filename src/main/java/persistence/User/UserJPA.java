package persistence.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import persistence.masterdata.MasterDataJPA;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "DHBW_Financeplanner")
public class UserJPA {

    @Id
    @Column(name = "vEmail")
    @Getter @Setter
    private String vEmail;

    @Basic
    @Column(name = "vName")
    @Getter @Setter
    private String vName;

    @Basic
    @Column(name = "lName")
    @Getter @Setter
    private String lName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJPA userJPA = (UserJPA) o;
        return Objects.equals(vEmail, userJPA.vEmail) &&
                Objects.equals(vName, userJPA.vName) &&
                Objects.equals(lName, userJPA.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vEmail, vName, lName);
    }
}
