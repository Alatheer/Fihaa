package com.Alatheer.alatheer.schoole.Models;

import java.io.Serializable;

/**
 * Created by elashry on 3/5/2018.
 */

public class ParentLoginModel implements Serializable{

    private int success;
    private String father_national_num;
    private String message;

    public ParentLoginModel() {
    }

    public ParentLoginModel(int success, String father_national_num, String message) {
        this.success = success;
        this.father_national_num = father_national_num;
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getFather_national_num() {
        return father_national_num;
    }

    public void setFather_national_num(String father_national_num) {
        this.father_national_num = father_national_num;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
