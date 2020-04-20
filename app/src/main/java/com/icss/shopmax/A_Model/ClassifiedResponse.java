
package com.icss.shopmax.A_Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassifiedResponse {

    @SerializedName("response")
    @Expose
    private Boolean response;
    @SerializedName("data")
    @Expose
    private List<Classified> data = null;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<Classified> getData() {
        return data;
    }

    public void setData(List<Classified> data) {
        this.data = data;
    }
}
