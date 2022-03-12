package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account account = new Account("John", "Silver");
        Account account1 = new Account("Madnu", "Platinum");
        Account account2 = new Account("Luca", "Test");
        // add them to our accounts list
        myAccounts.add(account);
        myAccounts.add(account1);
        myAccounts.add(account2);

        return myAccounts;
    }

    public void addAccount(Account account, boolean vipFlag) {
    System.out.println(getClass() + " : DOING MY DB WORK: ADDING ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doing my work");
        return false;
    }


    public String getName() {
        System.out.println(getClass() + " : : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : : in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : : in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
