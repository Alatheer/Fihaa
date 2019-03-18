package com.Alatheer.alatheer.schoole.Models;

import java.io.Serializable;

/**
 * Created by m on 3/5/2018.
 */

public class AllActivities_Model implements Serializable{
    private String activity_title;
    private String activity_content;
    private String activity_date;
    private String image_name;
    private String message;
    private String classrooms_name;
    private String school_name;
    private String sub_stages_name;

    public AllActivities_Model(String activity_title, String activity_content, String activity_date, String image_name, String message, String classrooms_name, String school_name, String sub_stages_name) {
        this.activity_title = activity_title;
        this.activity_content = activity_content;
        this.activity_date = activity_date;
        this.image_name = image_name;
        this.message = message;
        this.classrooms_name = classrooms_name;
        this.school_name = school_name;
        this.sub_stages_name = sub_stages_name;
    }

    public String getSub_stages_name() {
        return sub_stages_name;
    }

    public void setSub_stages_name(String sub_stages_name) {
        this.sub_stages_name = sub_stages_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getClassrooms_name() {
        return classrooms_name;
    }

    public void setClassrooms_name(String classrooms_name) {
        this.classrooms_name = classrooms_name;
    }

    public String getMessage() {
        return message;
    }

    public AllActivities_Model(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }

    public String getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(String activity_date) {
        this.activity_date = activity_date;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
