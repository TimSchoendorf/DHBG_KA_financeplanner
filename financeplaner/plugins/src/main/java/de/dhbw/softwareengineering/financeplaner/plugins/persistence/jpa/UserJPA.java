package de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "DHBW_Financeplanner")
public class UserJPA {

    @Id
    @Column(name = "vEmail")
    private String vEmail;

    @Basic
    @Column(name = "vName")
    private String vName;

    @Basic
    @Column(name = "lName")
    private String lName;

    // Standard getters and setters

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

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
