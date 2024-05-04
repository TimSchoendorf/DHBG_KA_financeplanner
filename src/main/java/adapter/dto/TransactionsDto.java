package adapter.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class TransactionsDto {
    private LocalDateTime dateTime;
    private double amount;
    private String description;
    private String particulars;
}
