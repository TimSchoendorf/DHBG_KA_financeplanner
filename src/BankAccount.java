import Exceptions.CountryNotSupported;
import Exceptions.InvalidIBAN;

import java.math.BigInteger;
import java.util.ArrayList;

public class BankAccount {

    // Create Option 1, with Splittet IBAN
    private int accountNumber;
    private int bankCode;
    private int checkDigit;
    private String countryCode;

    // Create Option 2 with singel Iban
    private String iban;

    private String accountType;
    private ArrayList<Transaction> transactions;

    private double dummyBalance; // This is only for Simulation


    public BankAccount(String iban) throws CountryNotSupported, InvalidIBAN {
        if (validateIBAN(iban)) splitIBAN(iban);
    }

    public BankAccount(int accountNumber, int bankCode, int checkDigit, String countryCode) throws CountryNotSupported, InvalidIBAN {
        String iban = constructIBAN(countryCode, checkDigit, bankCode, accountNumber);
        assert iban != null;
        if (validateIBAN(iban)) splitIBAN(iban);
    }

    private static String constructIBAN(String countryCode, int checkDigit, int bankCode, int accountNumber) throws CountryNotSupported, InvalidIBAN {
        String iban = String.format("%s%02d%08d%010d", countryCode, checkDigit, bankCode, accountNumber);
        if (validateIBAN(iban)) return iban;

        return null;
    }


    private static boolean validateIBAN(String iban) throws CountryNotSupported, InvalidIBAN {

        if (iban.substring(0, 2) != "DE") throw new CountryNotSupported(iban.substring(0, 2));
        String rearrangedIban = iban.substring(4) + iban.substring(0, 4);

        StringBuilder numericIBAN = new StringBuilder();
        for (int i = 0; i < rearrangedIban.length(); i++) {
            numericIBAN.append(Character.digit(rearrangedIban.charAt(i), 36));
        }


        BigInteger ibanNumber = new BigInteger(numericIBAN.toString());

        boolean validation = ibanNumber.mod(BigInteger.valueOf(97)).intValue() == 1;
        if (validation) return validation;
        else throw new InvalidIBAN(iban);
    }

    private void splitIBAN(String iban) {
        if (iban == null || iban.length() < 15) {
            return;
        }

        this.countryCode = iban.substring(0, 2);
        this.checkDigit = Integer.parseInt(iban.substring(2, 4));
        this.bankCode = Integer.parseInt(iban.substring(4, 12));
        this.accountNumber = Integer.parseInt(iban.substring(12)); // Restliche Ziffern als Kontonummer


    }

    public String getIban(){
        return this.iban;
    }
    public double getBalance() {

        for (Transaction transaction : transactions) {
            if (transaction.isPositiv()) dummyBalance += transaction.getAmount();
            else dummyBalance -= transaction.getAmount();
        }
        return dummyBalance;

    }

    public boolean setBalance(double balance) {
        this.dummyBalance = balance;
        return true;
    }

}
