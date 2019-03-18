package com.Alatheer.alatheer.schoole.MVP.Display_AllSubStages;

import android.content.Context;

import com.Alatheer.alatheer.schoole.Models.ModelStage;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void OnDisplayDataSuccess(List<ModelStage> schools_stages);
        void OnFailed(String error);
    }

    void DisplayAll_SubStages(String id_school,String id,String type,InterActor.onCompleteListener listener, Context context);

}
