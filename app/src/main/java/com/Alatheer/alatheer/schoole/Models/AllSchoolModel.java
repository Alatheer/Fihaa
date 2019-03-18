
package com.Alatheer.alatheer.schoole.Models;


public class AllSchoolModel {

    private String id_school;
    private String branch_id_fk;
    private String school_name;
    private String ministerial_number;
    private String phone;
    private String fax;
    private String email;
    private Double school_google_long;
    private Double school_google_lat;


    public AllSchoolModel() {
    }


    public AllSchoolModel(String id_school, String branch_id_fk, String school_name, String ministerial_number, String phone, String fax, String email, Double school_google_long, Double school_google_lat) {
        this.id_school = id_school;
        this.branch_id_fk = branch_id_fk;
        this.school_name = school_name;
        this.ministerial_number = ministerial_number;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.school_google_long = school_google_long;
        this.school_google_lat = school_google_lat;
    }

    public Double getSchool_google_long() {
        return school_google_long;
    }

    public void setSchool_google_long(Double school_google_long) {
        this.school_google_long = school_google_long;
    }

    public Double getSchool_google_lat() {
        return school_google_lat;
    }

    public void setSchool_google_lat(Double school_google_lat) {
        this.school_google_lat = school_google_lat;
    }

    public String getId_school() {
        return id_school;
    }

    public void setId_school(String id_school) {
        this.id_school = id_school;
    }

    public String getBranch_id_fk() {
        return branch_id_fk;
    }

    public void setBranch_id_fk(String branch_id_fk) {
        this.branch_id_fk = branch_id_fk;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getMinisterial_number() {
        return ministerial_number;
    }

    public void setMinisterial_number(String ministerial_number) {
        this.ministerial_number = ministerial_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

}
