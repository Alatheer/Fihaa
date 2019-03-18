package com.Alatheer.alatheer.schoole.Models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Delta on 04/03/2018.
 */

public class School_Stages1 implements Serializable {
    private List <Schools_Stages> array_stages;

    public School_Stages1() {
    }

    public School_Stages1(List<Schools_Stages> array_stages) {
        this.array_stages = array_stages;
    }

    public List<Schools_Stages> getArray_stages() {
        return array_stages;
    }

    public void setArray_stages(List<Schools_Stages> array_stages) {
        this.array_stages = array_stages;
    }
}

