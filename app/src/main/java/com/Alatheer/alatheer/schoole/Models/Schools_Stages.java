package com.Alatheer.alatheer.schoole.Models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Delta on 04/03/2018.
 */

public class Schools_Stages implements Serializable{

    private String main_stages_id;
    private String stage_name;
    private List <SubStages> sub_stage;

    public Schools_Stages() {
    }

    public Schools_Stages(String main_stages_id, String stage_name, List<SubStages> sub_stage) {
        this.main_stages_id = main_stages_id;
        this.stage_name = stage_name;
        this.sub_stage = sub_stage;
    }

    public String getMain_stages_id() {
        return main_stages_id;
    }

    public void setMain_stages_id(String main_stages_id) {
        this.main_stages_id = main_stages_id;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public List<SubStages> getSub_stage() {
        return sub_stage;
    }

    public void setSub_stage(List<SubStages> sub_stage) {
        this.sub_stage = sub_stage;
    }
}
