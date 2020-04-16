package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grocery_Data {

    @SerializedName("grocery_cat_id")
    @Expose
    private String grocery_cat_id;

    @SerializedName("grocery_cat_name")
    @Expose
    private String grocery_cat_name;

    @SerializedName("banner1")
    @Expose
    private String banner1;

    @SerializedName("banner2")
    @Expose
    private String banner2;

    @SerializedName("banner3")
    @Expose
    private String banner3;

    public String getGrocery_cat_id() {
        return grocery_cat_id;
    }

    public void setGrocery_cat_id(String grocery_cat_id) {
        this.grocery_cat_id = grocery_cat_id;
    }

    public String getGrocery_cat_name() {
        return grocery_cat_name;
    }

    public void setGrocery_cat_name(String grocery_cat_name) {
        this.grocery_cat_name = grocery_cat_name;
    }

    public String getBanner1() {
        return banner1;
    }

    public void setBanner1(String banner1) {
        this.banner1 = banner1;
    }

    public String getBanner2() {
        return banner2;
    }

    public void setBanner2(String banner2) {
        this.banner2 = banner2;
    }

    public String getBanner3() {
        return banner3;
    }

    public void setBanner3(String banner3) {
        this.banner3 = banner3;
    }
}
