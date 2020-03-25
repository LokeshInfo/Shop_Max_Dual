package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Doc_Book_Model {

    /*private Doc_Book_Data data;
*/
    @SerializedName("response")
    @Expose
    private Boolean response;

    @SerializedName("success_msg")
    @Expose
    private String success_msg;



    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public String getSuccess_msg() {
        return success_msg;
    }

    public void setSuccess_msg(String success_msg) {
        this.success_msg = success_msg;
    }
}
