package com.example.prem.trip.Model;

import com.google.gson.annotations.SerializedName;

public class ModelCategoryItemlist {

    //@SerializedName("id")
    private String  c_id;
    //@SerializedName("name")
    private String c_name;
    //constructor


    public ModelCategoryItemlist(String c_id, String c_name) {
        this.c_id = c_id;
        this.c_name = c_name;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
