package com.example.prem.trip.Model;

import android.widget.ScrollView;

public class ModelSubCategoryItemIist {
    private String id;
    private String name;
    private String description;
    private String c_id;
    private String img_url;

    public ModelSubCategoryItemIist(String id, String name, String description, String c_id, String img_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.c_id = c_id;
        this.img_url = img_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
