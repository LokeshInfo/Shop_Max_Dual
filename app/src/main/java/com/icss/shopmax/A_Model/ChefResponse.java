
package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChefResponse {

    @SerializedName("response")
    @Expose
    private Boolean response;
    @SerializedName("data")
    @Expose
    private List<Chef> chefList = null;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<Chef> getChefList() {
        return chefList;
    }

    public void setChefList(List<Chef> chefList) {
        this.chefList = chefList;
    }
}
