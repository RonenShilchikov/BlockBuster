package application.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import application.Book;
import application.Request;
import application.Video;

public class Model {
	public static void addVideo(String id,String name,String x,String description,int y,int d,int m,int year) {
		try {

			Video v= new Video(id , name , x , description , y , d , m , year);
			Gson gson = new Gson();
			Socket socket = new Socket("localhost", 34567);
			Request req = new Request("video/add",gson.toJson(v) );
			String json = gson.toJson(req);

			// message
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			String message = json;
			pr.println(message);
			pr.flush();

			// parse the json into a request object
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String message2 = br.readLine();
			
			System.out.println("req successful");
			
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("problem with req");

		} catch (IOException e) {
			System.out.println("problem with req");
		}
	}
	
	public static void addBook(String id,String name,String x,String description,int y,int d,int m,int year) {
		try {
			Gson gson = new Gson();
			
			Book b = new Book(id , name, x , description , y , d , m ,year);
			
			Socket socket = new Socket("localhost", 34567);
			Request req = new Request("book/add",gson.toJson(b) );
			String json = gson.toJson(req);

			// message
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			String message = json;
			pr.println(message);
			pr.flush();

			// parse the json into a request object
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String message2 = br.readLine();
			
			System.out.println("req successful");
			
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("problem with req");

		} catch (IOException e) {
			System.out.println("problem with req");
		}
	}
	
	public static void deleteVideo(String id) {
		try {
			Socket socket = new Socket("localhost", 34567);
			Gson gson = new Gson();
			Request req = new Request("video/remove", "{'id' : '"+id+"'}");
			String json = gson.toJson(req);

			// message
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			String message = json;
			pr.println(message);
			pr.flush();

			// parse the json into a request object
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String message2 = br.readLine();
			
			System.out.println("req successful");
			socket.close();

		} catch (UnknownHostException e) {
			System.out.println("problem with req");

		} catch (IOException e) {
			System.out.println("problem with req");
		}
	}
	
	public static void deleteBook(String id) {
		try {
			Socket socket = new Socket("localhost", 34567);
			Gson gson = new Gson();
			Request req = new Request("book/remove", "{'id' : '"+id+"'}");
			String json = gson.toJson(req);

			// message
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			String message = json;
			pr.println(message);
			pr.flush();

			// parse the json into a request object
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String message2 = br.readLine();
			
			System.out.println("req successful");
			socket.close();

		} catch (UnknownHostException e) {
			System.out.println("problem with req");

		} catch (IOException e) {
			System.out.println("problem with req");
		}
	}
	
	public static String getAllBooks() {
		try {
			Socket socket = new Socket("localhost", 34567);

			Gson gson = new Gson();

			Request req = new Request("book/getall", "");

			String json = gson.toJson(req);

			// message
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			String message = json;
			pr.println(message);
			pr.flush();

			// parse the json into a request object
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String message2 = br.readLine();
			System.out.println("req successful");
			socket.close();
			return message2;

		} catch (UnknownHostException e) {
			System.out.println("problem with req");
			return "";

		} catch (IOException e) {
			System.out.println("problem with req");
			return "";
		}
	}
	
	public static String getAllVideos() {
		try {
			
			Socket socket = new Socket("localhost", 34567);

			Gson gson = new Gson();

			Request req = new Request("video/getall", "");

			String json = gson.toJson(req);

			// message
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			String message = json;
			pr.println(message);
			pr.flush();

			// parse the json into a request object
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String message2 = br.readLine();

			System.out.println("req successful");
			socket.close();

			return message2;

		} catch (UnknownHostException e) {
			System.out.println("problem with req");
			return "";

		} catch (IOException e) {
			System.out.println("problem with req");
			return "";
		}
	}
}
