package com.BaseClasses.Class;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-9.
 * 产品库存管理
 * 创建一个管理产品库存的应用。
 * 建立一个产品类，包含价格、id、库存数量。
 * 然后建立一个库存类，记录各种产品并能计算库存的总价值。
 */
public class Warehouse {
    private double ans;
    private ArrayList<Product> list;

    public Warehouse() {
        ans = 0;
        list = new ArrayList<>();
    }

    public void add(Product p) {
        list.add(p);
        ans += p.getNum() * p.getPrice();
    }

    public void list() {
        for (Product p : list) {
            p.print();
        }
        System.out.println("Ans: " + ans);
    }

    public void remove(String s) {
        int i;
        for (i = 0; i < list.size(); ++i) {
            Product p = list.get(i);
            if (p.getId().equals(s)) {
                break;
            }
        }
        if (i != list.size()) {
            Product p = list.get(i);
            ans -= p.getNum() * p.getPrice();
            list.remove(i);
        }
    }

    public boolean hasProduct(String s) {
        for (Product p : list) {
            if (p.getId().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
