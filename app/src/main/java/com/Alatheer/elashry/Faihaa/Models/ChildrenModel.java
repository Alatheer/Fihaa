package com.Alatheer.elashry.Faihaa.Models;

import java.io.Serializable;

/**
 * Created by elashry on 3/12/2018.
 */

public class ChildrenModel implements Serializable {
    private String student_code;
    private String name;
    private String transport_type;
    private String payment_type;
    private String current_all_fees;
    private String current_remain;
    private String current_paid;
    private String sub_stages_name;
    private String classrooms_name;
    private String school_name;
    private String transport_fee;


    public ChildrenModel() {
    }

    public ChildrenModel(String student_code, String name, String transport_type, String payment_type, String current_all_fees, String current_remain, String current_paid, String sub_stages_name, String classrooms_name, String school_name, String transport_fee) {
        this.student_code = student_code;
        this.name = name;
        this.transport_type = transport_type;
        this.payment_type = payment_type;
        this.current_all_fees = current_all_fees;
        this.current_remain = current_remain;
        this.current_paid = current_paid;
        this.sub_stages_name = sub_stages_name;
        this.classrooms_name = classrooms_name;
        this.school_name = school_name;
        this.transport_fee = transport_fee;
    }


    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getCurrent_all_fees() {
        return current_all_fees;
    }

    public void setCurrent_all_fees(String current_all_fees) {
        this.current_all_fees = current_all_fees;
    }

    public String getCurrent_remain() {
        return current_remain;
    }

    public void setCurrent_remain(String current_remain) {
        this.current_remain = current_remain;
    }

    public String getCurrent_paid() {
        return current_paid;
    }

    public void setCurrent_paid(String current_paid) {
        this.current_paid = current_paid;
    }

    public String getSub_stages_name() {
        return sub_stages_name;
    }

    public void setSub_stages_name(String sub_stages_name) {
        this.sub_stages_name = sub_stages_name;
    }

    public String getClassrooms_name() {
        return classrooms_name;
    }

    public void setClassrooms_name(String classrooms_name) {
        this.classrooms_name = classrooms_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getTransport_fee() {
        return transport_fee;
    }

    public void setTransport_fee(String transport_fee) {
        this.transport_fee = transport_fee;
    }
}
