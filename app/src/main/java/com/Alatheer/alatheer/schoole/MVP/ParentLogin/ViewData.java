package com.Alatheer.alatheer.schoole.MVP.ParentLogin;

import com.Alatheer.alatheer.schoole.Models.ParentLoginModel;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void setUserIdError();
    void setNationalIdError();
    void OnDisplayDataSuccess(ParentLoginModel parentLoginModel);
    void OnFailed(String error);
}
