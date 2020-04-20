
package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodDishes {

    @SerializedName("food_dish_id")
    @Expose
    private String foodDishId;
    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("dish_type")
    @Expose
    private String dishType;
    @SerializedName("dish_name")
    @Expose
    private String dishName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("create_timestamp")
    @Expose
    private String createTimestamp;
    @SerializedName("banner")
    @Expose
    private String banner;

    public String getFoodDishId() {
        return foodDishId;
    }

    public void setFoodDishId(String foodDishId) {
        this.foodDishId = foodDishId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

}
