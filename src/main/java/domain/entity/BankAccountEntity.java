package domain.entity;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BankAccountEntity {
    private int accountNumber;
    private int bankCode;
    private int checkDigit;
    private String countryCode;

    // Create Option 2 with singel Iban
    private String iban;

    private String accountType;
    public ArrayList<TransactionsEnity> transactions;

    private double dummyBalance;
}
