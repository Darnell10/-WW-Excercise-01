package com.weightwatchers.ww_exercise_01.model;

public class WW_DataModel {


    private String title;

    private String image;

    public WW_DataModel(String title, String image) {

        this.title = title;
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}