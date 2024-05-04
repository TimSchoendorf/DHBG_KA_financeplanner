package Exceptions;

import java.math.BigInteger;

public class InvalidIBAN extends Exception {
    public InvalidIBAN(String iban) {

        String message = "";
        iban = iban.replace(" ", "");

        // Überprüfung der Länge
        if (iban.length() < 15 || iban.length() > 34) {
           message += " Invalid IBAN: Incorrect length. IBAN must be between 15 and 34 characters.";
        }

        // Überprüfung des Ländercodes
        String countryCode = iban.substring(0, 2);
        if (!countryCode.matches("[A-Z]{2}")) {
            message += " Invalid IBAN: The country code must be two uppercase letters.";
        }

        // Überprüfung der Prüfziffer
        String checkDigits = iban.substring(2, 4);
        if (!checkDigits.matches("\\d{2}")) {
           message += "Invalid IBAN: The check digits must be two digits.";
        }

        // Verschieben Sie die ersten vier Zeichen an das Ende und konvertieren Sie Buchstaben in Zahlen
        String rearrangedIban = iban.substring(4) + countryCode + checkDigits;
        StringBuilder numericIBAN = new StringBuilder();
        for (int i = 0; i < rearrangedIban.length(); i++) {
            numericIBAN.append(Character.digit(rearrangedIban.charAt(i), 36));
        }

        // Modulo 97 Prüfung
        BigInteger ibanNumber = new BigInteger(numericIBAN.toString());
        if (ibanNumber.mod(BigInteger.valueOf(97)).intValue() != 1) {
            message += "Invalid IBAN: The checksum is incorrect.";
        }

        super("IBAN: "+iban+" is incorrect: "+message);
        //todo better Handling
    }
}
