package de.dhbw.softwareengineering.financeplaner.domain.entity;

import java.util.ArrayList;

public class BankAccountEntity {
    private int accountNumber;
    private int bankCode;
    private int checkDigit;
    private String countryCode;

    // Create Option 2 with singel Iban
    private String iban;

    private String accountType;
    public ArrayList<TransactionsEntity> transactions;

    private double dummyBalance;

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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public ArrayList<TransactionsEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<TransactionsEntity> transactions) {
        this.transactions = transactions;
    }

    public double getDummyBalance() {
        return dummyBalance;
    }

    public void setDummyBalance(double dummyBalance) {
        this.dummyBalance = dummyBalance;
    }
}
