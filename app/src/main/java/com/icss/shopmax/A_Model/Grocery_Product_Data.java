package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grocery_Product_Data
{
    @SerializedName("grocery_item_id")
    @Expose
    private String grocery_item_id;

    @SerializedName("grocery_cat_id")
    @Expose
    private String grocery_cat_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("banner")
    @Expose
    private String banner;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("quantity")
    @Expose
    private String unit_quantity;

    public String getGrocery_item_id() {
        return grocery_item_id;
    }

    public void setGrocery_item_id(String grocery_item_id) {
        this.grocery_item_id = grocery_item_id;
    }

    public String getGrocery_cat_id() {
        return grocery_cat_id;
    }

    public void setGrocery_cat_id(String grocery_cat_id) {
        this.grocery_cat_id = grocery_cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnit_quantity() {
        return unit_quantity;
    }

    public void setUnit_quantity(String unit_quantity) {
        this.unit_quantity = unit_quantity;
    }
}
