package com.icss.shopmax.A_Model;

import java.util.List;

public class Doc_Book_Model {

    private List<Doc_Book_Data> data;

    private Boolean response;

    private String success_msg;


    public List<Doc_Book_Data> getData() {
        return data;
    }

    public void setData(List<Doc_Book_Data> data) {
        this.data = data;
    }

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
