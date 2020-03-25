package com.icss.shopmax.Model;

public class Hospital_Data {

    private String name;
    private String hospital;
    private String fees;
    private String description;

    public Hospital_Data(String name, String hospital, String fees, String description) {
        this.name = name;
        this.hospital = hospital;
        this.fees = fees;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
