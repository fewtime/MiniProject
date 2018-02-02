package com.Weather.Base;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-2.
 * Implement Data class.
 */

public class Data {
    private String shidu;
    private int pm25;
    private int pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private ArrayList<Forecast> forecast;

    public String getShidu() {
        return this.shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }


    public int getPm25() {
        return this.pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }


    public int getPm10() {
        return this.pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }


    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


    public String getWendu() {
        return this.wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }


    public String getGanmao() {
        return this.ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }


    public Yesterday getYesterday() {
        return this.yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }


    public ArrayList<Forecast> getForecast() {
        return this.forecast;
    }

    public void setForecast(ArrayList<Forecast> forecast) {
        this.forecast = forecast;
    }
}
