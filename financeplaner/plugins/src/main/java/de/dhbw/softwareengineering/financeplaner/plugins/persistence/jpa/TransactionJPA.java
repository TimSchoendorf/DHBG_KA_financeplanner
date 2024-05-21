package de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa;

import de.dhbw.softwareengineering.financeplaner.domain.Category;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isPositiv() {
        return positiv;
    }

    public void setPositiv(boolean positiv) {
        this.positiv = positiv;
    }
}
