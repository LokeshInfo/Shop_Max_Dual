package com.icss.shopmax.Model;

public class Food_Menu_Model
{
    private String food_name;
    private String food_price;
    private String food_description;
    private int qty;

    public Food_Menu_Model(String food_name, String food_price, String food_description, int qty) {
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_description = food_description;
        this.qty = qty;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_description() {
        return food_description;
    }

    public void setFood_description(String food_description) {
        this.food_description = food_description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
