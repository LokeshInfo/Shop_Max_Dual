package com.icss.shopmax.Model;

public class flight_data {

    private String name;
    private String price;
    private String type;
    private String date;
    private String deptime;
    private String arrtime;

    public flight_data(String name, String price, String type,String date,String deptime,String arrtime) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.date=date;
        this.arrtime=arrtime;
        this.deptime=deptime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public String getArrtime() {
        return arrtime;
    }

    public void setArrtime(String arrtime) {
        this.arrtime = arrtime;
    }
}
