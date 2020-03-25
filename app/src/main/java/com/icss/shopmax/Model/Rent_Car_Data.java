package com.icss.shopmax.Model;

public class Rent_Car_Data {

    private String name;
    private String car_model;
    private String price;
    private String type;

    public Rent_Car_Data(String name, String car_model, String price, String type) {
        this.name = name;
        this.car_model = car_model;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
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
}
