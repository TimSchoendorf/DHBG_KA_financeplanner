package de.dhbw.softwareengineering.financeplaner.plugins.persistence.jpa;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bank_account", schema = "DHBW_Financeplanner")
public class BankAccountJPA {

    @Id
    @Column(name = "iban")
    private String iban;

    @Basic
    @Column(name = "account_number")
    private int accountNumber;

    @Basic
    @Column(name = "bank_code")
    private int bankCode;

    @Basic
    @Column(name = "check_digit")
    private int checkDigit;

    @Basic
    @Column(name = "country_code")
    private String countryCode;

    @Basic
    @Column(name = "account_type")
    private String accountType;

    @Basic
    @Column(name = "dummyBalance")
    private double dummyBalance;
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public int getCheckDigit() {
        return checkDigit;
    }

    public void setCheckDigit(int checkDigit) {
        this.checkDigit = checkDigit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getDummyBalance() {
        return dummyBalance;
    }

    public void setDummyBalance(double dummyBalance) {
        this.dummyBalance = dummyBalance;
    }
}
