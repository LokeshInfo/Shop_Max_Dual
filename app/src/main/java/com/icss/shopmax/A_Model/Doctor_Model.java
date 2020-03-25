package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Doctor_Model {

    @SerializedName("response")
    @Expose
    private Boolean response;

    @SerializedName("data")
    @Expose
    private List<Doctor_data> data;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<Doctor_data> getData() {
        return data;
    }

    public void setData(List<Doctor_data> data) {
        this.data = data;
    }
}
