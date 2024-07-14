package com.hit.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

public class Response {
	String res;
	Request req;
	Socket clientSocket;
	Gson gson;
	
	public Response(Request req , String res , Socket s) {
		this.res = res;
		this.req = req;
		this.clientSocket = s;
		gson = new Gson();
	}
	
	public void sendBack() {
		try {
			System.out.println("imhere");
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
						
			pw.println(res);
			pw.flush();
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("cant send res back");
			e.printStackTrace();
		}
	}
}
