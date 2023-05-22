package com.ems.ems.project.exception;

public class UpdateNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	
	 public UpdateNotFoundException(String message){
        super(message);
    }

}
