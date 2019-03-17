package com.Alatheer.alatheer.schooles.Models;

import java.io.Serializable;

/**
 * Created by elashry on 3/5/2018.
 */

public class SubClasses implements Serializable {

    /*private String sub_stages_id;
    private String sub_stage_name;
    private String stage_name;

    public SubClasses() {
    }

    public SubClasses(String sub_stages_id, String sub_stage_name, String stage_name) {
        this.sub_stages_id = sub_stages_id;
        this.sub_stage_name = sub_stage_name;
        this.stage_name = stage_name;
    }

    public String getSub_stages_id() {
        return sub_stages_id;
    }

    public void setSub_stages_id(String sub_stages_id) {
        this.sub_stages_id = sub_stages_id;
    }

    public String getSub_stage_name() {
        return sub_stage_name;
    }

    public void setSub_stage_name(String sub_stage_name) {
        this.sub_stage_name = sub_stage_name;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }*/
     private String id;
    private String ar_name;
    private String en_name;
    private String division_num;
    private String thegreatest_num;
    private String sub_stages_id;
    private String school_id_fk;
    private String branch_id_fk;
    private String id_class_room;


    public SubClasses() {
    }

    public SubClasses(String id, String ar_name, String en_name, String division_num, String thegreatest_num, String sub_stages_id, String school_id_fk, String branch_id_fk, String id_class_room) {
        this.id = id;
        this.ar_name = ar_name;
        this.en_name = en_name;
        this.division_num = division_num;
        this.thegreatest_num = thegreatest_num;
        this.sub_stages_id = sub_stages_id;
        this.school_id_fk = school_id_fk;
        this.branch_id_fk = branch_id_fk;
        this.id_class_room = id_class_room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAr_name() {
        return ar_name;
    }

    public void setAr_name(String ar_name) {
        this.ar_name = ar_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getDivision_num() {
        return division_num;
    }

    public void setDivision_num(String division_num) {
        this.division_num = division_num;
    }

    public String getThegreatest_num() {
        return thegreatest_num;
    }

    public void setThegreatest_num(String thegreatest_num) {
        this.thegreatest_num = thegreatest_num;
    }

    public String getSub_stages_id() {
        return sub_stages_id;
    }

    public void setSub_stages_id(String sub_stages_id) {
        this.sub_stages_id = sub_stages_id;
    }

    public String getSchool_id_fk() {
        return school_id_fk;
    }

    public void setSchool_id_fk(String school_id_fk) {
        this.school_id_fk = school_id_fk;
    }

    public String getBranch_id_fk() {
        return branch_id_fk;
    }

    public void setBranch_id_fk(String branch_id_fk) {
        this.branch_id_fk = branch_id_fk;
    }

    public String getId_class_room() {
        return id_class_room;
    }

    public void setId_class_room(String id_class_room) {
        this.id_class_room = id_class_room;
    }
}
