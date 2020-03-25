package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hospital_data {

    @SerializedName("hospital_id")
    @Expose
    private String hospital_id;

    @SerializedName("hospital_name")
    @Expose
    private String hospital_name;

    @SerializedName("hospital_owner")
    @Expose
    private String hospital_owner;

    @SerializedName("hospital_add1")
    @Expose
    private String hospital_add1;

    @SerializedName("hospital_add2")
    @Expose
    private String hospital_add2;

    @SerializedName("hospital_city")
    @Expose
    private String hospital_city;

    @SerializedName("hospital_state")
    @Expose
    private String hospital_state;

    @SerializedName("hospital_country")
    @Expose
    private String hospital_country;

    @SerializedName("hospital_pno")
    @Expose
    private String hospital_pno;

    @SerializedName("banner")
    @Expose
    private String banner;

    @SerializedName("vendor_id")
    @Expose
    private String vendor_id;

    @SerializedName("status")
    @Expose
    private String status;

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getHospital_owner() {
        return hospital_owner;
    }

    public void setHospital_owner(String hospital_owner) {
        this.hospital_owner = hospital_owner;
    }

    public String getHospital_add1() {
        return hospital_add1;
    }

    public void setHospital_add1(String hospital_add1) {
        this.hospital_add1 = hospital_add1;
    }

    public String getHospital_add2() {
        return hospital_add2;
    }

    public void setHospital_add2(String hospital_add2) {
        this.hospital_add2 = hospital_add2;
    }

    public String getHospital_city() {
        return hospital_city;
    }

    public void setHospital_city(String hospital_city) {
        this.hospital_city = hospital_city;
    }

    public String getHospital_state() {
        return hospital_state;
    }

    public void setHospital_state(String hospital_state) {
        this.hospital_state = hospital_state;
    }

    public String getHospital_country() {
        return hospital_country;
    }

    public void setHospital_country(String hospital_country) {
        this.hospital_country = hospital_country;
    }

    public String getHospital_pno() {
        return hospital_pno;
    }

    public void setHospital_pno(String hospital_pno) {
        this.hospital_pno = hospital_pno;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
