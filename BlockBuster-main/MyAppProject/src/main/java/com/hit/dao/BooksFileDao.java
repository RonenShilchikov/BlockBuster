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
import com.hit.algorithm.MergeSortAlgo;
import com.hit.algorithm.QuickSortAlgo;
import com.hit.dm.Book;


public class BooksFileDao implements IDao<String, Book> {
	String path = "Books.json";
	static Gson gsonObj;
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	PrintWriter printWriter;
	IAlgoSort sorter;

	public BooksFileDao() throws IOException {
		//objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
		//objectInputStream = new ObjectInputStream(new FileInputStream(path));
		gsonObj = new Gson();
		sorter = new QuickSortAlgo();
		
	}

	@Override
	public void delete(String id) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
			String text = reader.readLine();
			Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
			ArrayList<Book> db = new Gson().fromJson(text, listType);
			reader.close();
			
			for(Book x : db) {
				if(x.getId().compareTo(id) == 0) {
					db.remove(x);
					String json = gsonObj.toJson(db);
					BufferedWriter writer = new BufferedWriter(new FileWriter("Books.txt"));
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
	public Book get(String id) {
		Book b = null;
		try {
			//read book create db
			BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
			String text = reader.readLine();
			Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
			ArrayList<Book> db = new Gson().fromJson(text, listType);
			reader.close();
			
			for(Book x : db) {
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
	public void save(Book b)  {

		try {
			//read book create db
			BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
			String text = reader.readLine();
			Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
			ArrayList<Book> db = new Gson().fromJson(text, listType);
			reader.close();
			//add b
			db.add(b);
			
			//write
			String json = gsonObj.toJson(db);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("Books.txt"));
			writer.write(json);
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

	public ArrayList<Book> getAll() {
		try {
			//read book create db
			BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
			String text = reader.readLine();
			
			Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
			
			
			ArrayList<Book> db = new Gson().fromJson(text, listType);
			reader.close();
			ArrayList<Book> sorter = sortArrayListWithAlgo(db);
			return sorter;
			
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
		return new ArrayList<Book>();
	}
	
	ArrayList<Book> sortArrayListWithAlgo(ArrayList<Book> arrayList) {
		
		for (Book b : arrayList) {
			System.out.println(b.toString());
		}
		
		Book[] array = arrayList.toArray(new Book[0]);
		
		sorter.sort(array);
		
		List list = Arrays.asList(array);
		
		ArrayList<Book> sortedArrayList = new ArrayList<Book>(list);
		
		for (Book b : sortedArrayList) {
			System.out.println(b.toString());
		}
	    return sortedArrayList;
	}
}
