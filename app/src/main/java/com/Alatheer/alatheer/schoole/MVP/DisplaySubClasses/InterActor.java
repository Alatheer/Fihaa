package com.Alatheer.alatheer.schoole.MVP.DisplaySubClasses;

import android.content.Context;

import com.Alatheer.alatheer.schoole.Models.Stud_ClassModel;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void OnDisplayDataSuccess(List<Stud_ClassModel> subClasses);
        void OnFailed(String error);
    }

    void DisplayAllSubClasses(String stud_id, InterActor.onCompleteListener listener, Context context);

}
