package com.hit.controller;

import java.util.ArrayList;

public interface Controller<T> {
	T get(String id);
	ArrayList<T> getAll();
	boolean delete(String id);
	boolean add(String object);
}
