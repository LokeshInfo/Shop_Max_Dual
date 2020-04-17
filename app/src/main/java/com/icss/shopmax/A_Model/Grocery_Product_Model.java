package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Grocery_Product_Model {

    @SerializedName("response")
    @Expose
    private Boolean response;

    @SerializedName("data")
    @Expose
    private List<Grocery_Product_Data> data;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<Grocery_Product_Data> getData() {
        return data;
    }

    public void setData(List<Grocery_Product_Data> data) {
        this.data = data;
    }
}
