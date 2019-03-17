package com.Alatheer.alatheer.schooles.Models;

import com.google.gson.annotations.SerializedName;

public class ArrayNewsItem{

	@SerializedName("news_date")
	private String newsDate;

	@SerializedName("image_name")
	private String imageName;

	@SerializedName("school_id")
	private String schoolId;

	@SerializedName("branch_id")
	private String branchId;

	@SerializedName("id_news")
	private String idNews;

	@SerializedName("school_name")
	private String schoolName;

	@SerializedName("news_content")
	private String newsContent;

	@SerializedName("id")
	private String id;

	@SerializedName("news_title")
	private String newsTitle;

	@SerializedName("news_video")
	private String newsVideo;

	@SerializedName("schools_id")
	private String schoolsId;

	public void setNewsDate(String newsDate){
		this.newsDate = newsDate;
	}

	public String getNewsDate(){
		return newsDate;
	}

	public void setImageName(String imageName){
		this.imageName = imageName;
	}

	public String getImageName(){
		return imageName;
	}

	public void setSchoolId(String schoolId){
		this.schoolId = schoolId;
	}

	public String getSchoolId(){
		return schoolId;
	}

	public void setBranchId(String branchId){
		this.branchId = branchId;
	}

	public String getBranchId(){
		return branchId;
	}

	public void setIdNews(String idNews){
		this.idNews = idNews;
	}

	public String getIdNews(){
		return idNews;
	}

	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}

	public String getSchoolName(){
		return schoolName;
	}

	public void setNewsContent(String newsContent){
		this.newsContent = newsContent;
	}

	public String getNewsContent(){
		return newsContent;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNewsTitle(String newsTitle){
		this.newsTitle = newsTitle;
	}

	public String getNewsTitle(){
		return newsTitle;
	}

	public void setNewsVideo(String newsVideo){
		this.newsVideo = newsVideo;
	}

	public String getNewsVideo(){
		return newsVideo;
	}

	public void setSchoolsId(String schoolsId){
		this.schoolsId = schoolsId;
	}

	public String getSchoolsId(){
		return schoolsId;
	}

	@Override
 	public String toString(){
		return 
			"ArrayNewsItem{" + 
			"news_date = '" + newsDate + '\'' + 
			",image_name = '" + imageName + '\'' + 
			",school_id = '" + schoolId + '\'' + 
			",branch_id = '" + branchId + '\'' + 
			",id_news = '" + idNews + '\'' + 
			",school_name = '" + schoolName + '\'' + 
			",news_content = '" + newsContent + '\'' + 
			",id = '" + id + '\'' + 
			",news_title = '" + newsTitle + '\'' + 
			",news_video = '" + newsVideo + '\'' + 
			",schools_id = '" + schoolsId + '\'' + 
			"}";
		}
}