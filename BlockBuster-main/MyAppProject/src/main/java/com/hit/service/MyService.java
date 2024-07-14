package com.hit.service;

import java.util.ArrayList;
import java.util.List;

import com.hit.dao.BooksFileDao;
import com.hit.dao.IDao;
import com.hit.dm.Book;
import com.hit.dm.Video;

public class MyService {
	//library service allows you to edit videos and books in the library
	
	IDao<String, Book> booksFileDao;
	IDao<String, Video> videoFileDao;

	
	public MyService(IDao<String, Book> bdao, IDao<String, Video> vdao) {
		this.booksFileDao = bdao;
		this.videoFileDao = vdao;
	}
	
	//books
	public Book getBookById(String id) {
		System.out.println("passd : " + id);
		Book b = booksFileDao.get(id);
		return b;
	}
	
	public void addBook(Book b) {
		booksFileDao.save(b);
	}
	
	public void removeBook(String id) {
		booksFileDao.delete(id);
	}
	
	public ArrayList<Book> getAllBooks() {
		return booksFileDao.getAll();
	}
	
	public MyService(IDao<String, Book> dao) {
		this.booksFileDao = dao;
	}
	
	
	//videos
	public Video getVideoById(String id) {
		Video v = videoFileDao.get(id);
		return v;
	}
	
	public void addVideo(Video v) {
		videoFileDao.save(v);
	}
	
	public void removeVideo(String id) {
		videoFileDao.delete(id);
	}
	
	public ArrayList<Video> getAllVideos() {
		return videoFileDao.getAll();
	}
	
	
}
