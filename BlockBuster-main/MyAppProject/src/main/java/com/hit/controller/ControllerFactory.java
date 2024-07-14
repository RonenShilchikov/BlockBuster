package com.hit.controller;

import java.io.IOException;

import com.hit.service.MyService;

public class ControllerFactory {

	
	public Controller create(String type , MyService service) throws IOException {
		if(type.equals("book")) {
			return new BookController(service);
		}
		else if(type.equals("video")) {
			return new VideoController(service);
		}
		else {
			return null; //error!
		}
	}
	
}
