package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sale_Model {

    @SerializedName("responce")
    @Expose
    private Boolean responce;

    @SerializedName("data")
    @Expose
    private List<Sale_Data> data;

    public Boolean getResponce() {
        return responce;
    }

    public void setResponce(Boolean responce) {
        this.responce = responce;
    }

    public List<Sale_Data> getData() {
        return data;
    }

    public void setData(List<Sale_Data> data) {
        this.data = data;
    }
}
