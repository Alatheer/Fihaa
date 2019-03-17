package com.Alatheer.alatheer.schooles.Models;

/**
 * Created by m on 3/5/2018.
 */

public class Student_State_Model {

    private String exam_name;
    private String student_name;
    private String subject_name;
    private String evaluatin_degree;
    private String message;


    public Student_State_Model(String exam_name, String student_name, String subject_name, String evaluatin_degree) {
        this.exam_name = exam_name;
        this.student_name = student_name;
        this.subject_name = subject_name;
        this.evaluatin_degree = evaluatin_degree;
    }

    public Student_State_Model(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getEvaluatin_degree() {
        return evaluatin_degree;
    }

    public void setEvaluatin_degree(String evaluatin_degree) {
        this.evaluatin_degree = evaluatin_degree;
    }
}
