package com.Alatheer.alatheer.schoole.Models;

/**
 * Created by elashry on 3/15/2018.
 */


public class AbsenceModel {

    private String student_name;
    private String absence_type_name;
    private String date_ar;

    public AbsenceModel(String student_name, String absence_type_name, String date_ar) {
        this.student_name = student_name;
        this.absence_type_name = absence_type_name;
        this.date_ar = date_ar;
    }

    public AbsenceModel() {
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getAbsence_type_name() {
        return absence_type_name;
    }

    public void setAbsence_type_name(String absence_type_name) {
        this.absence_type_name = absence_type_name;
    }

    public String getDate_ar() {
        return date_ar;
    }

    public void setDate_ar(String date_ar) {
        this.date_ar = date_ar;
    }
}
