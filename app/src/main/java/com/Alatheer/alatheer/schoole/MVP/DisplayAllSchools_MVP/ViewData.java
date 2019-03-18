package com.Alatheer.alatheer.schoole.MVP.DisplayAllSchools_MVP;

import com.Alatheer.alatheer.schoole.Models.AllSchoolModel;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(List<AllSchoolModel> allSchoolModelList);
    void OnFailed(String error);
}
