package com.BaseClasses.Class;

import java.util.Date;

/**
 * Created by cowlog on 18-2-9.
 * Implement VideoTape.
 */
public class VideoTape {
    private String id;
    private Date startDate;
    private Date endDate;
    private double penaty;

    public VideoTape(String id, Date startDate, Date endDate, double penaty) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.penaty = penaty;
    }

    void print() {
        System.out.println("ID: " + id
                + "\tStartDate: " + startDate.toString()
                + "\tEndDate: " + endDate.toString()
                + "\tpenaty: " + penaty);
    }
}
