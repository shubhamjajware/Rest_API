package com.api.beans;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
	
	private int statusCode;
	private String message;
	private List<Employee> data;
	
	public Response(int statusCode, String message, List<Employee> data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
}
