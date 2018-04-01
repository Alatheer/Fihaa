package com.Alatheer.elashry.Faihaa.Models;

import java.io.Serializable;

/**
 * Created by elashry on 4/1/2018.
 */

public class ModelStage implements Serializable{
    private String sub_stages_id;
    private String sub_stage_name;
    private String stage_name;

    public ModelStage() {
    }

    public ModelStage(String sub_stages_id, String sub_stage_name, String stage_name) {
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
    }
}
