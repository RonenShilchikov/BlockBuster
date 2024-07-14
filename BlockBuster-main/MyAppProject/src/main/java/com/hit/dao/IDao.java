package com.hit.dao;

import java.io.Serializable;
import java.util.ArrayList;

import com.hit.dm.Book;
import com.hit.dm.Video;

public interface IDao<ID , T> {
	T get(ID id);
	
	void delete(ID id);
	
	void save(T t);
	
	public ArrayList<T> getAll() ;

}
