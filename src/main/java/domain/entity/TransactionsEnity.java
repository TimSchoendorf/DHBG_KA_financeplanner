package domain.entity;

import z_helper.enumDefinition.Category;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TransactionsEnity {
    private LocalDateTime dateTime;
    private double amount;
    private String description;
    private String particulars;
    private String comment;
    private Category category;

    private boolean positiv;
}
