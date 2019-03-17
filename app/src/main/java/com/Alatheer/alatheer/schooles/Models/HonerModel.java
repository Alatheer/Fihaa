package com.Alatheer.alatheer.schooles.Models;

/**
 * Created by elashry on 3/4/2018.
 */

public class HonerModel {

    private String student_name;
    private String degree;
    private String message;

    public HonerModel(String student_name, String degree) {
        this.student_name = student_name;
        this.degree = degree;
    }

    public HonerModel() {
    }

    public HonerModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
