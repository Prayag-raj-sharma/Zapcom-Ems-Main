package com.ems.ems.project.exception;

import java.util.HashMap;
import java.util.Map;

public class EmployeeError {

	private long empId;
	
	private String message;
	
	Map<String,String> errors;

	public EmployeeError(long empId, String message, Map<String, String> errors) {
		super();
		this.empId = empId;
		this.message = message;
		this.errors = errors;
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

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
}
