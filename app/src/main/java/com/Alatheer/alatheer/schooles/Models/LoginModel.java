package com.Alatheer.alatheer.schooles.Models;

import java.io.Serializable;

/**
 * Created by elashry on 3/5/2018.
 */

public class LoginModel implements Serializable{

    private int success;
    private String student_code;
    private String message;

    public LoginModel() {

    }

    public LoginModel(int success, String student_code, String message) {
        this.success = success;
        this.student_code = student_code;
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
