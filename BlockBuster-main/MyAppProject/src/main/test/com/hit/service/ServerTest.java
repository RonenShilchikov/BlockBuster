package com.hit.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.hit.dao.BooksFileDao;
import com.hit.dm.Book;
import com.hit.server.Request;
import com.hit.server.Server;

public class ServerTest {
	public static void main(String[] args) {
//		try {
//			
//			//server
//			Server server = new Server(12345);
//			Thread myT = new Thread(server);
//			myT.start();
//			
//			//connect
//			Socket socket = new Socket("localhost" , 12345);
//			+
//			
//			
//			
//			//Request
//			Book addme = new Book("77", "777", "777", "7777", 7, 7, 7, 1977);
//			Gson gson = new Gson();
//			
//			Request req = new Request("book/getall", gson.toJson(addme));
//			
//			String json = gson.toJson(req);
//			
//			//message
//			PrintWriter pr = new PrintWriter(socket.getOutputStream());
//			String message = json;
//			pr.println(message);
//			pr.flush();
//			
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
		
	}
	
	
	
	
	
	
//	void server_start_send_receive() {
//		Server server = new Server(12345);
//		Thread myT = new Thread(server);
//		myT.start();
//		
//		try {
//			Socket socket = new Socket("localhost" , 12345);
//			PrintWriter pr = new PrintWriter(socket.getOutputStream());
//			String message = "Hi from client";
//			pr.println(message);
//			pr.flush();
//			
//			InputStreamReader in = new InputStreamReader(socket.getInputStream());
//			BufferedReader br = new BufferedReader(in);
//			String serverMessage = br.readLine();
//			
//			System.out.println("from server : " + serverMessage);
//			
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
