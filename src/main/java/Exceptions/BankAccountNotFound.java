package Exceptions;

public class BankAccountNotFound extends Exception {
    public BankAccountNotFound() {
        super("Bank Account Not Found, Pleas Check youre IBAN");
    }
}
