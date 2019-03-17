package com.Alatheer.alatheer.schooles.MVP.LoginMVP;

import com.Alatheer.alatheer.schooles.Models.LoginModel;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void setUserIdError();
    void setNationalIdError();
    void OnDisplayDataSuccess(LoginModel loginModel);
    void OnFailed(String error);
}
