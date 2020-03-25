package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register_Data {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("token_code")
    @Expose
    private String token_code;

    @SerializedName("create_date")
    @Expose
    private String create_date;

    @SerializedName("ip_address")
    @Expose
    private String ip_address;

    @SerializedName("status")
    @Expose
    private float status;

    @SerializedName("responce")
    @Expose
    private boolean responce;

    @SerializedName("data")
    @Expose
    private float data;

    @SerializedName("error")
    @Expose
    private String error;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken_code() {
        return token_code;
    }

    public void setToken_code(String token_code) {
        this.token_code = token_code;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public boolean isResponce() {
        return responce;
    }

    public void setResponce(boolean responce) {
        this.responce = responce;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }


}
