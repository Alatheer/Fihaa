package com.Alatheer.alatheer.schooles.MVP.Display_AllSubStages;

import com.Alatheer.alatheer.schooles.Models.ModelStage;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(List<ModelStage> schools_stages);

    void OnFailed(String error);

}
