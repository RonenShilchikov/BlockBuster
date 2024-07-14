package com.hit.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.hit.dao.BooksFileDao;
import com.hit.dao.VideoFileDao;
import com.hit.dm.Book;
import com.hit.dm.Video;
import com.hit.service.MyService;

public class VideoController implements Controller<Video>{
	Gson gson;
	MyService service;
	
	public VideoController(MyService service) throws IOException {
		gson = new Gson();
		this.service = service;
	}
	@Override
	public ArrayList<Video> getAll() {
		return service.getAllVideos();
	}

	@Override
	public Video get(String body) {
		//get the id
		Video x = gson.fromJson(body, Video.class);
		x = service.getVideoById(x.getId());
		return x;
		}
	@Override
	public boolean delete(String body) {
		//get the id
		Video x = gson.fromJson(body, Video.class);
		service.removeVideo(x.getId());
		return true;
	}
	
	@Override
	public boolean add(String objectInBody) {
		Video x = gson.fromJson(objectInBody, Video.class);
		service.addVideo(x);
		return true;
	}
	
	
}
