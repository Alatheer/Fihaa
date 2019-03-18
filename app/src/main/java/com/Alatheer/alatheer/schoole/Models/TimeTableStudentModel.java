package com.Alatheer.alatheer.schoole.Models;

/**
 * Created by elashry on 3/15/2018.
 */

public class TimeTableStudentModel {
    private String school_schedule_images;

    public TimeTableStudentModel(String school_schedule_images) {
        this.school_schedule_images = school_schedule_images;
    }

    public TimeTableStudentModel() {
    }

    public String getSchool_schedule_images() {
        return school_schedule_images;
    }

    public void setSchool_schedule_images(String school_schedule_images) {
        this.school_schedule_images = school_schedule_images;
    }
}
