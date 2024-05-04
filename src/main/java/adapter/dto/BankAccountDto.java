package adapter.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter
public class BankAccountDto {
    private int accountNumber;
    private int bankCode;
    private int checkDigit;
    private String countryCode;

    // Create Option 2 with singel Iban
    private String iban;

    private String accountType;
    public ArrayList<TransactionsDto> transactions;
    private double dummyBalance; // This is only for Simulation
}
