package com.example.a16023018.p02_holidays;

public class Holidays {

    private String name;
    private String date;
    private int icon;

    public Holidays( String name, String date, int icon){

        this.name = name;
        this.date = date;
        this.icon = icon;
    }

    public String getName(){
        return name;
    }

    public String getDate() {
        return date;
    }
    public int getIcon() {
        return icon;
    }
}
