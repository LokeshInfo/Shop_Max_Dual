package com.icss.shopmax.Model;

public class Sale_Data
{
    String Name;
    String Price;
    String Description;

    public Sale_Data(String name, String price, String description) {
        Name = name;
        Price = price;
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
