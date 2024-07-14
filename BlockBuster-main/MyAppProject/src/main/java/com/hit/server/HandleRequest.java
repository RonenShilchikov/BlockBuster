package com.hit.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.Socket;


import com.google.gson.Gson;
import com.hit.controller.Controller;
import com.hit.controller.ControllerFactory;
import com.hit.dao.BooksFileDao;
import com.hit.dao.VideoFileDao;
import com.hit.dm.Book;
import com.hit.server.Request.Headers;
import com.hit.service.MyService;

public class HandleRequest implements Runnable{
	
	Socket clientSocket;
	Request req;
	Response res;
	Headers headers;
	Gson gson;
	ControllerFactory controllerFactory;
	
	String body, route , command;
	
	MyService service;
	
	
	public HandleRequest(Socket s , MyService service) {
		this.clientSocket = s;
		gson = new Gson();
		controllerFactory = new ControllerFactory();
		this.service= service;
	}
	
	@Override
	public void run() {
		try {
			//parse the json into a request object
			InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader br = new BufferedReader(in);
			
			String message = br.readLine();
			
			req = gson.fromJson(message, Request.class);
			
			body = req.body;
			
			route = req.headers.action.split("/")[0].toLowerCase();
			command = req.headers.action.split("/")[1].toLowerCase();
			
			System.out.println(route);
			System.out.println(command);

			//create the relevant controller (from controller factory)
			Controller controller = controllerFactory.create(route , service);
			
			if(command.equals("getall") ) {
				var x = controller.getAll();
				res = new Response(req, gson.toJson(x), clientSocket);
				res.sendBack();
			}
			else if(command.equals("remove")) {
				var x = controller.delete(req.body);
				res = new Response(req, gson.toJson(x), clientSocket);
				res.sendBack();
			}
			else if(command.equals("add")) {
				var x = controller.add(req.body);
				res = new Response(req, gson.toJson(x), clientSocket);
				res.sendBack();
			}
			else if(command.equals("get")) {
				var x = controller.get(req.body);
				res = new Response(req, gson.toJson(x), clientSocket);
				res.sendBack();
			}
		} catch (IOException e) {
			res = new Response(req, "failed" , clientSocket);
			res.sendBack();
		}
	}

}


