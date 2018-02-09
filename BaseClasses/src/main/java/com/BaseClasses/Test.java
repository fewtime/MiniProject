package com.BaseClasses;

import com.BaseClasses.Class.*;

import java.util.Date;

/**
 * Created by cowlog on 18-2-9.
 * Test class.
 */

/*
银行账户管家——创建一个名为“Account”的抽象类，有三个为“CheckingAccount”、“SavingsAccount”和“BusinessAccount”的子类。通过类似ATM的程序来管理这些账户的借贷。
*/
public class Test {
    public static void main(String[] args) {
        // 产品库存管理
        System.out.println("Warehouse: ");
        Warehouse w = new Warehouse();
        for (int i = 1; i <= 5; ++i) {
            Product p = new Product(Integer.toString(i), i*10, i*20);
            w.add(p);
        }
        w.list();
        for (int i = 1; i <= 3; ++i)  {
            if (w.hasProduct(Integer.toString(i))) {
                w.remove(Integer.toString(i));
            }
        }
        w.list();
        // 电影商城
        System.out.println("Cinema: ");
        Cinema c = new Cinema();
        for (int i = 1; i <=5; ++i) {
            VideoTape t = new VideoTape(Integer.toString(i), new Date(), new Date(), i * 10);
            c.add(t);
        }
        c.list();
        // 馆藏目录
        System.out.println("Library: ");
        Library l = new Library();
        for (int i = 1; i <= 5; ++i) {
            Book b = new Book(Integer.toString(i), i * 100, Integer.toString(i * 10), false);
            l.add(b);
        }
        l.list();
        for (int i = 1; i <= 5; i += 2) {
            Book b = l.get(Integer.toString(i));
            if (b.isRent()) {
                System.out.println("ID: " + i + " cannot be rent.");
            } else {
                b.rent();
            }
        }
        l.list();
        for (int i = 1; i <= 5; i += 2) {
            Book b = l.get(Integer.toString(i));
            if (b.isRent()) {
                System.out.println("ID: " + i + " is returned.");
            } else {
                b.returned();
            }
        }
        l.list();
        // 学生成绩管理器
        System.out.println("ScoreNote: ");
        ScoreNote sn = new ScoreNote();
        for (int i = 1; i <=5; ++i) {
            Student s = new Student(Integer.toString(i));
            for (int j = 10; j <=30; j += 10) {
                Subject sb = new Subject(Integer.toString(j), j + 50);
                s.add(sb);
            }
            sn.add(s);
        }
        sn.list();

        //  酒店预订系统
        System.out.println("Hotel: ");
        Hotel h = new Hotel();
        for (int i = 1; i <=5; ++i) {
            Room r = new Room(i, i % 2, false, i * 10);
            h.add(r);
        }
        h.list();
    }
}
