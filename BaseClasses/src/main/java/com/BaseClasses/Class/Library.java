package com.BaseClasses.Class;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-9.
 * 馆藏目录
 * 创建一个图书类，记录书名、页数、国际标准书号、是否借出。
 * 用它来管理各种书籍，允许用户进行借出和归还操作。
 * TODO: 复杂一点的话，可以生成逾期图书和逾期费用的报告。
 * TODO: 也可以让用户进行预约操作。
 */
public class Library {
    private ArrayList<Book> list;

    public Library() {
        this.list = new ArrayList<>();
    }

    public void add(Book b) {
        list.add(b);
    }

    public void list() {
        for (Book b : list) {
            b.print();
        }
    }

    public Book get(String id) {
        Book b = null;
        for (Book p: list) {
            if (p.getId().equals(id)) {
                b = p;
            }
        }
        return b;
    }
}
