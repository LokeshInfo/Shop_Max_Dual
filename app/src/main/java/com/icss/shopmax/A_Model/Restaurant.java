
package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("restaurant_name")
    @Expose
    private String restaurantName;
    @SerializedName("restaurant_owner")
    @Expose
    private String restaurantOwner;
    @SerializedName("restaurant_add1")
    @Expose
    private String restaurantAdd1;
    @SerializedName("restaurant_add2")
    @Expose
    private String restaurantAdd2;
    @SerializedName("restaurant_city")
    @Expose
    private String restaurantCity;
    @SerializedName("restaurant_state")
    @Expose
    private String restaurantState;
    @SerializedName("restaurant_country")
    @Expose
    private String restaurantCountry;
    @SerializedName("restaurant_pno")
    @Expose
    private String restaurantPno;
    @SerializedName("banner")
    @Expose
    private String banner;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("create_timestamp")
    @Expose
    private String createTimestamp;
    @SerializedName("status")
    @Expose
    private String status;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantOwner() {
        return restaurantOwner;
    }

    public void setRestaurantOwner(String restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }

    public String getRestaurantAdd1() {
        return restaurantAdd1;
    }

    public void setRestaurantAdd1(String restaurantAdd1) {
        this.restaurantAdd1 = restaurantAdd1;
    }

    public String getRestaurantAdd2() {
        return restaurantAdd2;
    }

    public void setRestaurantAdd2(String restaurantAdd2) {
        this.restaurantAdd2 = restaurantAdd2;
    }

    public String getRestaurantCity() {
        return restaurantCity;
    }

    public void setRestaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

    public String getRestaurantState() {
        return restaurantState;
    }

    public void setRestaurantState(String restaurantState) {
        this.restaurantState = restaurantState;
    }

    public String getRestaurantCountry() {
        return restaurantCountry;
    }

    public void setRestaurantCountry(String restaurantCountry) {
        this.restaurantCountry = restaurantCountry;
    }

    public String getRestaurantPno() {
        return restaurantPno;
    }

    public void setRestaurantPno(String restaurantPno) {
        this.restaurantPno = restaurantPno;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
