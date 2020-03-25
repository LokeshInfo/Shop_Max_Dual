package com.icss.shopmax.Model;

public class Grocery_data {

    private String name;
    private String unit;
    private String price;
    private int qty;

    public Grocery_data(String name, String unit, String price, int qty) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
