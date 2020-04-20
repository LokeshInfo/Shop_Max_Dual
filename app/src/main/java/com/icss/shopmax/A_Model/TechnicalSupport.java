
package com.icss.shopmax.A_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechnicalSupport {

    @SerializedName("sub_service_id")
    @Expose
    private String subServiceId;
    @SerializedName("service_id")
    @Expose
    private String serviceId;
    @SerializedName("sub_service_name")
    @Expose
    private String subServiceName;
    @SerializedName("banner")
    @Expose
    private String banner;
    @SerializedName("status")
    @Expose
    private String status;

    public String getSubServiceId() {
        return subServiceId;
    }

    public void setSubServiceId(String subServiceId) {
        this.subServiceId = subServiceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public void setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
