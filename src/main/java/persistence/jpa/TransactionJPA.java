package persistence.jpa;

import z_helper.enumDefinition.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "transaction", schema = "DHBW_Financeplanner")
public class TransactionJPA {

    @Id
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "particulars")
    private String particulars;

    @Column(name = "comment")
    private String comment;

    @Column(name="category")
    private Category category;

    @Column(name = "positiv")
    private boolean positiv;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionJPA that = (TransactionJPA) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(positiv, that.positiv) &&
                Objects.equals(particulars, that.particulars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, amount, description, particulars, positiv);
    }
}
