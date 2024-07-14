package com.hit.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.google.gson.reflect.TypeToken;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.hit.algorithm.BubbleSortAlgo;
import com.hit.algorithm.IAlgoSort;
import com.hit.algorithm.QuickSortAlgo;
import com.hit.dm.Book;
import com.hit.dm.Video;

public class VideoFileDao implements IDao<String, Video> {
	String path ;
	static Gson gsonObj;
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	PrintWriter printWriter;
	IAlgoSort sorter;
	

	public VideoFileDao() throws IOException {
		path = "Video.txt";
		//objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
		//objectInputStream = new ObjectInputStream(new FileInputStream(path));
		gsonObj = new Gson();
		sorter = new QuickSortAlgo();
	}

	@Override
	public void delete(String id) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Video.txt"));
			String text = reader.readLine();
			
			System.out.println("file read : " +text);
			
			Type listType = new TypeToken<ArrayList<Video>>(){}.getType();
			ArrayList<Video> db = new Gson().fromJson(text, listType);
			reader.close();
			
			for(Video x : db) {
				if(x.getId().compareTo(id) == 0) {
					System.out.println("found to remove");
					db.remove(x);
					String json = gsonObj.toJson(db);
					BufferedWriter writer = new BufferedWriter(new FileWriter("Video.txt"));
					writer.write(json);
					writer.close();
					return ;
					}
			}

		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public Video get(String id) {
		Video b = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Video.txt"));
			String text = reader.readLine();
			Type listType = new TypeToken<ArrayList<Video>>(){}.getType();
			ArrayList<Video> db = new Gson().fromJson(text, listType);
			reader.close();
			
			for(Video x : db) {
				if(x.getId().equals(id)) return x;
			}
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void save(Video b)  {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Video.txt"));
			String text = reader.readLine();
			
			System.out.println(text);

			
			Type listType = new TypeToken<ArrayList<Video>>(){}.getType();
			ArrayList<Video> db = new Gson().fromJson(text, listType);
			
			//add b
			db.add(b);
			
			//write
			String json = gsonObj.toJson(db);
			

			BufferedWriter writer = new BufferedWriter(new FileWriter("Video.txt"));
			writer.write(json);
			reader.close();
			writer.close();
			
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Video> getAll() {
		try {
			
			//read book create db
			BufferedReader reader = new BufferedReader(new FileReader("Video.txt"));
			String text = reader.readLine();
			
			
			Type listType = new TypeToken<ArrayList<Video>>(){}.getType();
			
			
			ArrayList<Video> db = new Gson().fromJson(text, listType);
			reader.close();
			
			ArrayList<Video> s = sortArrayListWithAlgo(db);
			
			return s;
			
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Video>();
	}
	
	
	ArrayList<Video> sortArrayListWithAlgo(ArrayList<Video> arrayList) {
		
		for (Video video : arrayList) {
			System.out.println(video.toString());
		}
		
		Video[] array = arrayList.toArray(new Video[0]);
		
		sorter.sort(array);
		
		List list = Arrays.asList(array);
		
		ArrayList<Video> sortedArrayList = new ArrayList<Video>(list);
		
		for (Video video : sortedArrayList) {
			System.out.println(video.toString());
		}
	    return sortedArrayList;
	}
	
	
}
