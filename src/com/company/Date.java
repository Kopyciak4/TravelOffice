package com.company;

import java.util.StringTokenizer;

public class Date {


    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static Date of(String date) {
       String[] tab = date.split("-");
       int year = Integer.parseInt(tab[0]);
       int month = Integer.parseInt(tab[1]);
       int day = Integer.parseInt(tab[2]);

       return new Date(year, month, day);
    }


}
