import Exceptions.BankAccountNotFound;
import Exceptions.CountryNotSupported;
import Exceptions.InvalidIBAN;
import enumDefinition.CountryCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class User {
    private String vName;
    private String lName;
    private String vEmail;
    private MasterData address;
    private ArrayList<BankAccount> accounts;

    public User(String vName, String lName, String vEmail,String street, String city, String state, String zip) throws CountryNotSupported {
        if (!state.equals(CountryCode.DE.toString())) throw new CountryNotSupported(state);
        this.vName = vName;
        this.lName = lName;
        this.vEmail = vEmail;
        this.address = new MasterData(street, city, state, zip);
    }

    public boolean addBankAccount(String IBAN, double dummyBalance) {
        try {
            accounts.add(new BankAccount(IBAN));
            accounts.getLast().setBalance(dummyBalance);
            return true;
        } catch (CountryNotSupported | InvalidIBAN e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeBankAccount(String IBAN) {
        try {
            accounts.remove(findBankAccountByIBAN(IBAN));
            return true;
        } catch (BankAccountNotFound e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean newTransaction(String IBAN, double amount, LocalDateTime time) {
        try {
            accounts.get(findBankAccountByIBAN(IBAN)).transactions.add(new Transaction(amount,time));
            return true;
        } catch (BankAccountNotFound e) {
            return false;
        }
    }


    private int findBankAccountByIBAN(String iban) throws BankAccountNotFound {
        for(int index =0; index < accounts.size(); index++) {
            if (accounts.get(index).getIban().equals(iban)) {
                return index;
            }
            else{
                throw new BankAccountNotFound();
            }
        }
    }

}
