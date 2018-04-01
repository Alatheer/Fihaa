package com.Alatheer.elashry.Faihaa.Models;

import java.io.Serializable;

/**
 * Created by elashry on 4/1/2018.
 */

public class Stud_ClassModel implements Serializable{
    private String class_name;
    private String id_class_room;

    public Stud_ClassModel() {
    }

    public Stud_ClassModel(String class_name, String id_class_room) {
        this.class_name = class_name;
        this.id_class_room = id_class_room;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getId_class_room() {
        return id_class_room;
    }

    public void setId_class_room(String id_class_room) {
        this.id_class_room = id_class_room;
    }
}
