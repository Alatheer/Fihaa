package com.Alatheer.alatheer.schoole.MVP.ParentLogin;

import android.content.Context;

import com.Alatheer.alatheer.schoole.Models.ParentLoginModel;

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
    public void setUserIdError() {
        if (viewData!=null)
        {
            viewData.setUserIdError();
        }
    }


    @Override
    public void setNationalIdError() {
        if (viewData!=null)
        {
            viewData.setNationalIdError();
        }
    }

    @Override
    public void OnDisplayDataSuccess(ParentLoginModel parentLoginModel) {
        if (viewData!=null)
        {
            viewData.OnDisplayDataSuccess(parentLoginModel);
        }
    }

    @Override
    public void OnFailed(String error) {
        if (viewData!=null)
        {
            viewData.OnFailed(error);
        }
    }

    @Override
    public void Login(String user_id) {
        interActor.Login(user_id,this,context);
    }
}
