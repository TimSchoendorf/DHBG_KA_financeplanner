package persistence.BankAccount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Entity
@Table(name = "bank_account", schema = "DHBW_Financeplanner")
public class BankAccountJPA {

    @Id
    @Column(name = "iban")
    @Getter @Setter
    private String iban;

    @Basic
    @Column(name = "account_number")
    @Getter @Setter
    private int accountNumber;

    @Basic
    @Column(name = "bank_code")
    @Getter @Setter
    private int bankCode;

    @Basic
    @Column(name = "check_digit")
    @Getter @Setter
    private int checkDigit;

    @Basic
    @Column(name = "country_code")
    @Getter @Setter
    private String countryCode;

    @Basic
    @Column(name = "account_type")
    @Getter @Setter
    private String accountType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountJPA that = (BankAccountJPA) o;
        return accountNumber == that.accountNumber &&
                bankCode == that.bankCode &&
                checkDigit == that.checkDigit &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, accountNumber, bankCode, checkDigit, countryCode, accountType);
    }
}
