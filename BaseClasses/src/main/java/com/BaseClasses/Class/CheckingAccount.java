package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-10.
 * Implement CheckingAccount.
 */
public class CheckingAccount extends Account{
    public CheckingAccount(String name, double balance) {
        super(name, balance);
        this.rate = 1.5;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name
                + "\tBalance: " + balance
                + "\tRate: " + rate);
    }
}
