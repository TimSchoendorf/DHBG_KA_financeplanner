package adapter.dto;

import java.time.LocalDateTime;

import enumDefinition.Category;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class TransactionsDto {
    private LocalDateTime dateTime;
    private double amount;
    private String description;
    private String particulars;
    private String comment;
    private Category category;
    private boolean positiv;
}
