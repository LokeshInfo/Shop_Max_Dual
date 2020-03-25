package com.icss.shopmax.Model;

public class Chef_Model
{
    private String name;
    private String image;
    private int status;


    public Chef_Model(String name, String image, int status) {
        this.name = name;
        this.image = image;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
