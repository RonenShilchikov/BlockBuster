package com.hit.server;

import java.io.Serializable;

public class Request implements Serializable {
	Headers headers;
	public String body;
	
	public Request(String headers , String body) {
		this.headers = new Headers(headers);
		this.body = body;
	}
	
	
	class Headers{
		String action;
		public Headers(String action) {
			this.action = action;
		}
	}

}