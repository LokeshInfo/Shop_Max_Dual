
package com.icss.shopmax.A_Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechnicalSupportResponse {

    @SerializedName("response")
    @Expose
    private Boolean response;
    @SerializedName("data")
    @Expose
    private List<TechnicalSupport> data = null;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<TechnicalSupport> getData() {
        return data;
    }

    public void setData(List<TechnicalSupport> data) {
        this.data = data;
    }
}
