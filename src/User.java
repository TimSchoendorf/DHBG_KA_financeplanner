import Exceptions.CountryNotSupported;
import Exceptions.InvalidIBAN;
import enumDefinition.CountryCode;

import java.util.ArrayList;

public class User {
    private String vName;
    private String lName;
    private String vEmail;
    private uAddress address;
    private ArrayList<BankAccount> accounts;

    public User(String vName, String lName, String vEmail,String street, String city, String state, String zip) throws CountryNotSupported {
        if (!state.equals(CountryCode.DE.toString())) throw new CountryNotSupported(state);
        this.vName = vName;
        this.lName = lName;
        this.vEmail = vEmail;
        this.address = new uAddress(street, city, state, zip);
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
        for(int index =0; index < accounts.size(); index++) {
            if (accounts.get(index).getIban().equals(IBAN)) {
                accounts.remove(index);
                return true;
            }
        }
        return false;
    }

}
