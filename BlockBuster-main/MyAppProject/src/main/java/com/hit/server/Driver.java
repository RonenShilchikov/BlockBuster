package com.hit.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.hit.dm.Book;
import com.hit.dm.Video;

public class Driver {
	public static void main(String[] args) {
		if(true) {
			Server server = new Server(34567);
			new Thread(server).start();
		}
		
		
	}
}
