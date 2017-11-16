package com.qq.dto;

import java.io.Serializable;

public class AirIndex implements Serializable {
    private int day;
    private int aqi;
    private int pm25;
    private int pm10;
    private double co;
    private int no2;
    private int so2;
    private String level;

    public AirIndex(int day, int aqi, int pm25, int pm10, double co, int no2, int so2, String level) {
        this.day = day;
        this.aqi = aqi;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.co = co;
        this.no2 = no2;
        this.so2 = so2;
        this.level = level;
    }

    public int getDay() {
        return day;
    }

    public int getAqi() {
        return aqi;
    }

    public int getPm25() {
        return pm25;
    }

    public int getPm10() {
        return pm10;
    }

    public double getCo() {
        return co;
    }

    public int getNo2() {
        return no2;
    }

    public int getSo2() {
        return so2;
    }

    public String getLevel() {
        return level;
    }
}
