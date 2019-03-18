package com.Alatheer.alatheer.schoole.Models;

import java.io.Serializable;

/**
 * Created by elashry on 4/1/2018.
 */

public class ModelStage_Parent implements Serializable{
    private String student_code;
    private String sub_stage_name;
    private String stage_name;

    public ModelStage_Parent() {
    }

    public ModelStage_Parent(String student_code, String sub_stage_name, String stage_name) {
        this.student_code = student_code;
        this.sub_stage_name = sub_stage_name;
        this.stage_name = stage_name;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
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
    }
}
