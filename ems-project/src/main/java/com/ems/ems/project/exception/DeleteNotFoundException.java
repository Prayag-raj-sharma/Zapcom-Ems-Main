package com.ems.ems.project.exception;

public class DeleteNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	 public DeleteNotFoundException(String message){
       super(message);
   }
}
