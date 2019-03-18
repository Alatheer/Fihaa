package com.Alatheer.alatheer.schoole.Models;

import java.io.Serializable;

/**
 * Created by Delta on 04/03/2018.
 */

public class SubStages implements Serializable {
    private String id;
    private String ar_name;
    private String en_name;
    private String tuition_fees;
    private String transfer_fees_1;
    private String transfer_fees_2;
    private String living_writing;
    private String other_fees;
    private String main_stages_id;
    private String school_id_fk;
    private String branch_id_fk;
    private String suspend;
    private String sub_stages_name;
    private String sub_stages_id;

    public SubStages() {
    }

    public SubStages(String id, String ar_name, String en_name, String tuition_fees, String transfer_fees_1, String transfer_fees_2, String living_writing, String other_fees, String main_stages_id, String school_id_fk, String branch_id_fk, String suspend, String sub_stages_name, String sub_stages_id) {
        this.id = id;
        this.ar_name = ar_name;
        this.en_name = en_name;
        this.tuition_fees = tuition_fees;
        this.transfer_fees_1 = transfer_fees_1;
        this.transfer_fees_2 = transfer_fees_2;
        this.living_writing = living_writing;
        this.other_fees = other_fees;
        this.main_stages_id = main_stages_id;
        this.school_id_fk = school_id_fk;
        this.branch_id_fk = branch_id_fk;
        this.suspend = suspend;
        this.sub_stages_name = sub_stages_name;
        this.sub_stages_id = sub_stages_id;
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

    public String getTransfer_fees_2() {
        return transfer_fees_2;
    }

    public void setTransfer_fees_2(String transfer_fees_2) {
        this.transfer_fees_2 = transfer_fees_2;
    }

    public String getLiving_writing() {
        return living_writing;
    }

    public void setLiving_writing(String living_writing) {
        this.living_writing = living_writing;
    }

    public String getOther_fees() {
        return other_fees;
    }

    public void setOther_fees(String other_fees) {
        this.other_fees = other_fees;
    }

    public String getMain_stages_id() {
        return main_stages_id;
    }

    public void setMain_stages_id(String main_stages_id) {
        this.main_stages_id = main_stages_id;
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

    public String getSuspend() {
        return suspend;
    }

    public void setSuspend(String suspend) {
        this.suspend = suspend;
    }

    public String getSub_stages_name() {
        return sub_stages_name;
    }

    public void setSub_stages_name(String sub_stages_name) {
        this.sub_stages_name = sub_stages_name;
    }

    public String getSub_stages_id() {
        return sub_stages_id;
    }

    public void setSub_stages_id(String sub_stages_id) {
        this.sub_stages_id = sub_stages_id;
    }
}
