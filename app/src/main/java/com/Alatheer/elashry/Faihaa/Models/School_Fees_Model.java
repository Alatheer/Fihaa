package com.Alatheer.elashry.Faihaa.Models;

/**
 * Created by m on 3/5/2018.
 */


public class School_Fees_Model {

    private String school_name;
    private String ar_name;
    private String phone;
    private String fax;
    private String email;
    private String tuition_fees;
    private String transfer_fees_1;
    private String transfer_fees_2;
    private Double school_google_lat;
    private Double school_google_long;
    private String message;

    public School_Fees_Model(String school_name, String ar_name, String tuition_fees, String transfer_fees_1, String transfer_fees_2, Double school_google_lat, Double school_google_long, String message) {
        this.school_name = school_name;
        this.ar_name = ar_name;
        this.tuition_fees = tuition_fees;
        this.transfer_fees_1 = transfer_fees_1;
        this.transfer_fees_2 = transfer_fees_2;
        this.school_google_lat = school_google_lat;
        this.school_google_long = school_google_long;
        this.message = message;
    }

    public String getTransfer_fees_2() {
        return transfer_fees_2;
    }

    public void setTransfer_fees_2(String transfer_fees_2) {
        this.transfer_fees_2 = transfer_fees_2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public Double getSchool_google_lat() {
        return school_google_lat;
    }

    public void setSchool_google_lat(Double school_google_lat) {
        this.school_google_lat = school_google_lat;
    }

    public Double getSchool_google_long() {
        return school_google_long;
    }

    public void setSchool_google_long(Double school_google_long) {
        this.school_google_long = school_google_long;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAr_name() {
        return ar_name;
    }

    public void setAr_name(String ar_name) {
        this.ar_name = ar_name;
    }

    public String getTuition_fees() {
        return tuition_fees;
    }

    public void setTuition_fees(String tuition_fees) {
        this.tuition_fees = tuition_fees;
    }

    public String getTransfer_fees_1() {
        return transfer_fees_1;
    }

    public void setTransfer_fees_1(String transfer_fees_1) {
        this.transfer_fees_1 = transfer_fees_1;
    }
}
