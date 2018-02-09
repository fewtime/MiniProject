package com.BaseClasses;

import com.BaseClasses.Class.Product;
import com.BaseClasses.Class.Warehouse;

/**
 * Created by cowlog on 18-2-9.
 * Test class.
 */

/*
电影商店——管理录像带租借，记录借出时间、到期时间、逾期费用。复杂一点可以生成逾期用户的账号报告。
航空/酒店预订系统——创建一套预订航班或酒店的预订系统。不同的航班座位和酒店房间收费不一样。譬如头等舱要比经济舱贵。带阁楼的套间要更贵些。记录下何时有空房可供预订。
学生成绩管理器——记录一个班级的学生（创建一个Student类，记录他们的名字、平均分和考试分数）和他们的成绩等级。根据学生的测验和作业的分数计算出平均分和成绩等级。复杂一点可以将数据画在贝尔曲线上。
银行账户管家——创建一个名为“Account”的抽象类，有三个为“CheckingAccount”、“SavingsAccount”和“BusinessAccount”的子类。通过类似ATM的程序来管理这些账户的借贷。
馆藏目录——创建一个图书类，记录书名、页数、国际标准书号、是否借出。用它来管理各种书籍，允许用户进行借出和归还操作。复杂一点的话，可以生成逾期图书和逾期费用的报告。也可以让用户进行预约操作。
*/
public class Test {
    public static void main(String[] args) {
        // 产品库存管理
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
    }
}
