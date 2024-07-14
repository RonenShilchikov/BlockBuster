package com.hit.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.hit.dao.BooksFileDao;
import com.hit.dm.Book;
import com.hit.service.MyService;

public class BookController implements Controller<Book>{
	MyService service;
	Gson gson;
	
	public BookController(MyService service) throws IOException {
		gson = new Gson();
		this.service = service;
		}
	@Override
	public ArrayList<Book> getAll() {
		return service.getAllBooks();
	}

	@Override
	public Book get(String body) {
		//get the id
		Book x = gson.fromJson(body, Book.class);
		x = service.getBookById(x.getId());
		return x;
		}
	@Override
	public boolean delete(String body) {

		//get the id
		Book x = gson.fromJson(body, Book.class);
		System.out.println("!!!");
		System.out.println(x.getId());

		service.removeBook(x.getId());
		return true;
	}
	
	@Override
	public boolean add(String objectInBody) {
		Book x = gson.fromJson(objectInBody, Book.class);
		service.addBook(x);
		return true;
	}
	
}
