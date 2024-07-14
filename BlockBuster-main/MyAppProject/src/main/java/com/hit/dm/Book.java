package com.hit.dm;

import java.io.Serializable;

public class Book implements Serializable , Comparable<Book>{
	
	String id,name , author, description;
	int pages , releaseDay,releaseMonth , releaseYear;
	 public Book(String id , String name , String author, String description , int pages , int releaseDay,int releaseMonth , int releaseYear) {
		 this.id = id;
		 this.name = name;
		 this.author = author;
		 this.description = description;
		 this.releaseDay = releaseDay;
		 this.pages = pages;
		 this.releaseYear = releaseYear;
		 this.releaseMonth = releaseMonth;
	 }
	 
	//getters
	 
	 public String getId() {
		return id;
	}
	public String getAuthor() {
		return author;
	}
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public int getPages() {
		return pages;
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
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPages(int pages) {
		this.pages = pages;
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
		return "ID : " +id + " Author : " + author + " Name : " + name + " Realeased : " + releaseYear ;
	}

	@Override
	public int compareTo(Book o) {
		return name.compareTo(o.getName());
	}
}
