package com.ems.ems.project.exception;

import org.springframework.data.util.Pair;

public class Response {
	
	private long empId;
	private String message;
	
	public Response() {
		
	}

	public Response(long empId, String message) {
		super();
		this.empId = empId;
		this.message = message;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
