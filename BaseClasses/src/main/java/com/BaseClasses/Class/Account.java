package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-10.
 * 银行账户管家
 * 创建一个名为“Account”的抽象类
 * 有三个为“CheckingAccount”、
 * “SavingsAccount”和“BusinessAccount”的子类。
 * TODO: 通过类似ATM的程序来管理这些账户的借贷。
 */
public abstract class Account {
    String name;
    double balance;
    double rate;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.rate = 0;
    }

    public abstract  void print();
}
