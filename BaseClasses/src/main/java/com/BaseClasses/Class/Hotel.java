package com.BaseClasses.Class;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-10.
 * 酒店预订系统
 * 创建一套酒店的预订系统。
 * 不同的酒店房间收费不一样。
 * 如带阁楼的套间要更贵些。
 * 记录下何时有空房可供预订。
 */
public class Hotel {
    private ArrayList<Room> list;
    public Hotel() {
        list = new ArrayList<>();
    }
    public void add(Room r) {
        list.add(r);
    }

    public void list() {
        for (Room r : list) {
            r.print();
        }
    }
}
