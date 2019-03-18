package com.Alatheer.alatheer.schoole.MVP.DisplayAllSchools_MVP;

import android.content.Context;

import com.Alatheer.alatheer.schoole.Models.AllSchoolModel;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public class PresenterImp implements Presenter ,InterActor.onCompleteListener{

    private ViewData viewData;
    private InterActor interActor;
    private Context context;

    public PresenterImp(ViewData viewData, Context context) {
        this.viewData = viewData;
        this.context = context;
        interActor = new InterActorImp();
    }

    @Override
    public void DisplayAllSchools() {
        interActor.DisplayAllSchools(this,context);
    }

    @Override
    public void OnDisplayDataSuccess(List<AllSchoolModel> allSchoolModelList) {
        if (viewData!=null)
        {
            viewData.OnDisplayDataSuccess(allSchoolModelList);
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
