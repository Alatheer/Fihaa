package com.Alatheer.alatheer.schooles.Models;

/**
 * Created by elashry on 3/15/2018.
 */

public class HomeWorkModel {
    private String homework_image;

    public HomeWorkModel(String homework_image) {
        this.homework_image = homework_image;
    }

    public HomeWorkModel() {
    }

    public String getHomework_image() {
        return homework_image;
    }

    public void setHomework_image(String homework_image) {
        this.homework_image = homework_image;
    }
}
