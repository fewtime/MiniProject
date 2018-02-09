package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-10.
 * Implement room.
 */
public class Room {
    private int id;
    private int level;
    private boolean isAvaliable;
    private double price;

    public Room(int id, int level, boolean isAvaliable, double price) {
        this.id = id;
        this.level = level;
        this.isAvaliable = isAvaliable;
        this.price = price;
    }

    public void print() {
        System.out.println("ID: " + id
            + "Level: " + level
            + "is avaliable: " + isAvaliable
            + "price: " + price);
    }
}
