package com.Alatheer.alatheer.schooles.MVP.DisplaySubClasses;

import com.Alatheer.alatheer.schooles.Models.Stud_ClassModel;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(List<Stud_ClassModel> subClasses);
    void OnFailed(String error);
}
