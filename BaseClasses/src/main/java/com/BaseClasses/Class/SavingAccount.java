package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-10.
 * Implement SavingAccount.
 */
public class SavingAccount extends Account{
    public SavingAccount(String name, double balance) {
        super(name, balance);
        this.rate = 4.5;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name
                + "\tBalance: " + balance
                + "\tRate: " + rate);
    }
}
