package com.icss.shopmax.Adapter;

public class vehicle_list_Data {
    private String type;
    private String search;

    public vehicle_list_Data(String type, String search) {
        this.type = type;
        this.search = search;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
