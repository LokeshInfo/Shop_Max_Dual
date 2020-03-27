package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Services_Model {

    @SerializedName("response")
    @Expose
    private Boolean response;

    @SerializedName("data")
    @Expose
    private List<Services_data> data;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<Services_data> getData() {
        return data;
    }

    public void setData(List<Services_data> data) {
        this.data = data;
    }
}
