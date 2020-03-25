package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor_data {

    @SerializedName("doctor_id")
    @Expose
    private String doctor_id;

    @SerializedName("hospital_id")
    @Expose
    private String hospital_id;

    @SerializedName("doctor_name")
    @Expose
    private String doctor_name;

    @SerializedName("specialist")
    @Expose
    private String specialist;

    @SerializedName("fees")
    @Expose
    private String fees;

    @SerializedName("vendor_id")
    @Expose
    private String vendor_id;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("banner")
    @Expose
    private String image;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
