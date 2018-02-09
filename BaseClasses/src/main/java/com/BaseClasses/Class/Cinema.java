package com.BaseClasses.Class;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-9.
 * 电影商店
 * 管理录像带租借，记录借出时间、到期时间、逾期费用。
 * TODO: 复杂一点可以生成逾期用户的账号报告。
 */
public class Cinema {
    private ArrayList<VideoTape> list;

    public Cinema() {
        this.list = new ArrayList<>();
    }

    public void list() {
        for (VideoTape t : list) {
            t.print();
        }
    }


    public void add(VideoTape t) {
        list.add(t);
    }
}
