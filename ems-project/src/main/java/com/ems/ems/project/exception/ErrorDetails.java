package com.ems.ems.project.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	//private Long id;
	private String message;
	private String error;
	
	public ErrorDetails() {
		
	}
	
	
	public ErrorDetails(Date timestamp, String message, String error) {
		super();
		this.timestamp = timestamp;
		//this.id = id;
		this.message = message;
		this.error = error;
		
	}


	public Date getTimestamp() {
		return timestamp;
	}
    

	public String getMessage() {
		return message;
	}


	public String getError() {
		return error;
	}

}
