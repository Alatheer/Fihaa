package com.Alatheer.elashry.Faihaa.MVP.Display_AllSubStages;

import android.content.Context;

import com.Alatheer.elashry.Faihaa.Models.ModelStage;
import com.Alatheer.elashry.Faihaa.Models.School_Stages1;

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
    public void DisplayAll_SubStages(String id_school,String id,String type) {
        interActor.DisplayAll_SubStages(id_school,id,type,this,context);
    }

    @Override
    public void OnDisplayDataSuccess(List<ModelStage> schools_stages) {
        if (viewData!=null)
        {
            viewData.OnDisplayDataSuccess(schools_stages);
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
