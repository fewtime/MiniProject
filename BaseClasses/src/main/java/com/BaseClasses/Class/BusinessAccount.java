package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-10.
 * Implement BusinessAccount
 */
public class BusinessAccount extends Account{
    public BusinessAccount(String name, double balance) {
        super(name, balance);
        this.rate = 0.5;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name
                + "\tBalance: " + balance
                + "\tRate: " + rate);
    }
}
