package com.Alatheer.alatheer.schoole.MVP.DisplayAllSchools_MVP;

import android.content.Context;

import com.Alatheer.alatheer.schoole.Models.AllSchoolModel;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void OnDisplayDataSuccess(List<AllSchoolModel> allSchoolModelList);
        void OnFailed(String error);
    }

    void DisplayAllSchools(InterActor.onCompleteListener listener, Context context);

}
