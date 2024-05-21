package de.dhbw.softwareengineering.financeplaner.domain.entity;

import java.util.ArrayList;
public class UserEntity {
    private String vName;
    private String lName;
    private String vEmail;
    private MasterDataEntity address;
    private ArrayList<BankAccountEntity> accounts;

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public MasterDataEntity getAddress() {
        return address;
    }

    public void setAddress(MasterDataEntity address) {
        this.address = address;
    }

    public ArrayList<BankAccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<BankAccountEntity> accounts) {
        this.accounts = accounts;
    }
}
