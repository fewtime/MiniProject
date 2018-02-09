package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-9.
 * Implement Product.
 */
public class Product {
    private String id;
    private double price;
    private int num;

    double getPrice() {
        return price;
    }

    int getNum() {
        return num;
    }

    String getId() {
        return id;
    }


    public Product(String id, double price, int num) {
        this.id = id;
        this.price = price;
        this.num = num;
    }

    void print() {
        System.out.println("ID: " + id + "\tprice: " + price + "\tnum: " + num);
    }
}
