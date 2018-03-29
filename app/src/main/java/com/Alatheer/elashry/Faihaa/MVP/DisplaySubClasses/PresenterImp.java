package com.Alatheer.elashry.Faihaa.MVP.DisplaySubClasses;

import android.content.Context;

import com.Alatheer.elashry.Faihaa.Models.SubClasses;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public class PresenterImp implements Presenter,InterActor.onCompleteListener{

    private ViewData viewData;
    private InterActor interActor;
    private Context context;

    public PresenterImp(ViewData viewData, Context context) {
        this.viewData = viewData;
        this.context = context;
        interActor = new InterActorImp();
    }

    @Override
    public void DisplayAllSubClasses(String id_school, String id , String type) {
        interActor.DisplayAllSubClasses(id_school,id,type,this,context);
    }

    @Override
    public void OnDisplayDataSuccess(List<SubClasses> subClasses) {
        if (viewData!=null)
        {
            viewData.OnDisplayDataSuccess(subClasses);
        }
    }

    @Override
    public void OnFailed(String error) {
        if (viewData!=null)
        {
            viewData.OnFailed(error);
        }
    }
}
