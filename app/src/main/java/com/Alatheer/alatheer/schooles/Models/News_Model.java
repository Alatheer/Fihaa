package com.Alatheer.alatheer.schooles.Models;

import java.io.Serializable;

/**
 * Created by ok on 29/01/2018.
 */

public class News_Model implements Serializable {

    private String id;

    private String schools_id;

    private String news_date;

    private String news_title;

    private String news_content;

    private String news_video;

    private String branch_id;

    private String id_news;

    private String school_id;

    private String school_name;

    private String image_name;
    private String message;

    public News_Model() {
    }

    public News_Model(String id, String schools_id, String news_date, String news_title, String news_content, String news_video, String branch_id, String id_news, String school_id, String school_name, String image_name, String message) {
        this.id = id;
        this.schools_id = schools_id;
        this.news_date = news_date;
        this.news_title = news_title;
        this.news_content = news_content;
        this.news_video = news_video;
        this.branch_id = branch_id;
        this.id_news = id_news;
        this.school_id = school_id;
        this.school_name = school_name;
        this.image_name = image_name;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchools_id() {
        return schools_id;
    }

    public void setSchools_id(String schools_id) {
        this.schools_id = schools_id;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_video() {
        return news_video;
    }

    public void setNews_video(String news_video) {
        this.news_video = news_video;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getId_news() {
        return id_news;
    }

    public void setId_news(String id_news) {
        this.id_news = id_news;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
