package com.BaseClasses;

import com.BaseClasses.Class.*;

import java.util.Date;

/**
 * Created by cowlog on 18-2-9.
 * Test class.
 */

/*
航空/酒店预订系统——创建一套预订航班或酒店的预订系统。不同的航班座位和酒店房间收费不一样。譬如头等舱要比经济舱贵。带阁楼的套间要更贵些。记录下何时有空房可供预订。
学生成绩管理器——记录一个班级的学生（创建一个Student类，记录他们的名字、平均分和考试分数）和他们的成绩等级。根据学生的测验和作业的分数计算出平均分和成绩等级。复杂一点可以将数据画在贝尔曲线上。
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
    }
}
