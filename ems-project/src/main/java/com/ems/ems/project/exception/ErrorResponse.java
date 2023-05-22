package com.ems.ems.project.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus errorCode;
	private String errorMessage;
	//private HashMap<String,String> error;
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(HttpStatus errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
