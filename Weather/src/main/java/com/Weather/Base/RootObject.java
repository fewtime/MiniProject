package com.Weather.Base;

/**
 * Created by cowlog on 18-2-2.
 * Implement RootObject class.
 */

public class RootObject {
    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private Data data;

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

