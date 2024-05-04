import java.math.BigInteger;

public class BankAccount {
    private int accountNumber;
    private int bankCode;
    private int checkDigit;
    private String countryCode;

    private String accountType;

    private int dummyBalance; // This is only for Simulation


    public BankAccount() {}

    public BankAccount(int accountNumber, int bankCode, int checkDigit, String countryCode, int balance, String accountType) {
        constructIBAN(countryCode,checkDigit,bankCode,accountNumber);
    }

    private static String constructIBAN( String countryCode, int checkDigit, int bankCode, int accountNumber) {
        String iban = String.format("%s%02d%08d%010d", countryCode, checkDigit, bankCode, accountNumber);
        if(validateIBAN(iban)) return iban;

        return null;
    }

    private static boolean validateIBAN(String iban) {
        iban = iban.substring(4) + iban.substring(0, 4);
        StringBuilder numericIBAN = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            numericIBAN.append(Character.digit(iban.charAt(i), 36));
        }

        BigInteger ibanNumber = new BigInteger(numericIBAN.toString());
        return ibanNumber.mod(BigInteger.valueOf(97)).intValue() == 1;
    }

    public int getBalance(){
        return dummyBalance;
        // Connect to Bank API to get current Balance
    }

}
