package com.hit.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.hit.ClockPackage.Clock;
//import com.hit.clock.Clock;
import com.hit.dao.BooksFileDao;
import com.hit.dao.VideoFileDao;
import com.hit.service.MyService;

public class Server implements Runnable {
	private ServerSocket server;
	int port;
	MyService service;
	Clock clock;
	boolean running;
	//Clock clock;

	public Server(int port) {
		this.port = port;
		running = true;
		clock = new Clock();
	}

	@Override
	public void run() {
		try {

			// create the service
			service = new MyService(new BooksFileDao(), new VideoFileDao());

			// listen for a req
			server = new ServerSocket(port);
			
			Thread clockThread = new Thread(clock);
			clockThread.start();
			
			while (running) {
				Socket clientSocket = server.accept();
				System.out.println("Request Received! Server is running for: " + clock.getTime("hh:mm:ss") + " amount of time"); 
				// run a handle request thread
				HandleRequest handler = new HandleRequest(clientSocket, service);
				Thread t = new Thread(handler);
				t.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
