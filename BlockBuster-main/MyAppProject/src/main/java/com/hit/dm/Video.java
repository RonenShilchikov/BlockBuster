package com.hit.dm;

import java.io.Serializable;

public class Video implements Serializable , Comparable<Video>{
	
	String id,name , director, description;
	int minutesLong , releaseDay,releaseMonth , releaseYear;
	 public Video(String id , String name , String director, String description , int minutesLong , int releaseDay,int releaseMonth , int releaseYear) {
		 this.id = id;
		 this.name = name;
		 this.director = director;
		 this.description = description;
		 this.releaseDay = releaseDay;
		 this.minutesLong = minutesLong;
		 this.releaseYear = releaseYear;
		 this.releaseMonth = releaseMonth;
	 }
	 
	//getters
	 
	 public String getId() {
		return id;
	}
	public String getDirector() {
		return director;
	}
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public int getMinutesLong() {
		return minutesLong;
	} 
	public int getReleaseDay() {
		return releaseDay;
	}
	public int getReleaseMonth() {
		return releaseMonth;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	
	//setters
	public void setId(String id) {
		this.id = id;
	}
	
	public void setAuthor(String director) {
		this.director = director;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPages(int minutesLong) {
		this.minutesLong = minutesLong;
	}
	public void setReleaseDay(int releaseDay) {
		this.releaseDay = releaseDay;
	}
	public void setReleaseMonth(int releaseMonth) {
		this.releaseMonth = releaseMonth;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	@Override
	public String toString() {
		return "ID : " +id + " Director : " + director + " Name : " + name + " Realeased : " + releaseYear ;
	}

	@Override
	public int compareTo(Video o) {
		return name.compareTo(o.getName());
	}
}
