package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddBookingIT {
    //    private String user_id;
//    private String sub_service_id;
//    private String first_name;
//    private String middle_name;
//    private String last_name;
//    private String email;
//    private String mobile_no;
//    private String address;
//    private String district;
//    private String city;
//    private String date;
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
