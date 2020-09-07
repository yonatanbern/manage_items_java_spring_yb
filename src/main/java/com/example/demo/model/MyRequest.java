package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyRequest {

	private final String req;
	private final int num;
	
	
	public MyRequest(@JsonProperty("operation name") String req, @JsonProperty("amount") int num) {
		this.req = req;
		this.num = num;
	}


	public String getReq() {
		return req;
	}


	public int getNum() {
		return num;
	}
	
	
}
