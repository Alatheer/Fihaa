package com.Alatheer.elashry.Faihaa.MVP.Display_AllSubStages;

import com.Alatheer.elashry.Faihaa.Models.ModelStage;
import com.Alatheer.elashry.Faihaa.Models.School_Stages1;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(List<ModelStage> schools_stages);

    void OnFailed(String error);

}
