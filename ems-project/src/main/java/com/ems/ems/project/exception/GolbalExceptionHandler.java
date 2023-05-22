package com.ems.ems.project.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.helpers.ThreadLocalMapOfStacks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GolbalExceptionHandler  {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public EmployeeError resourceNotFoundException(ResourceNotFoundException ex) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("errorMessage", "Employee Id can not be negative..Try other value...");
		map.put("errorCode", "500");
        EmployeeError error = new EmployeeError(-1,"Failure",map);
		return error;
    }

	
	@ExceptionHandler(UpdateNotFoundException.class)
    public EmployeeError updateNotFoundException(UpdateNotFoundException ex) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("errorMessage", "Cannot update for this empId..Try other one..");
		map.put("errorCode", "404");
		
		EmployeeError error = new EmployeeError(-1,"Failure",map);
        return error;
    }
	
	@ExceptionHandler(DeleteNotFoundException.class)
    public EmployeeError deleteNotFoundException(DeleteNotFoundException ex) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("errorMessage", "Employee of this empId is not present..Try other one..");
		map.put("errorCode", "404");
        EmployeeError error = new EmployeeError(-1,"Failure",map);
		return error;
    }
	
	@ExceptionHandler(AddressNotFoundException.class)
    public ErrorResponse addressNotFoundException(AddressNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"You cannot add address for this empId..Try other one..");
        return errorResponse;
    }
	
	

   /* @ExceptionHandler(Exception.class)
    public EmployeeError globleExceptionHandler(Exception ex, WebRequest request) {
    	Map<String,String> map = new HashMap<String,String>();
		map.put("errorMessage", "Check Your Inputs");
		map.put("errorCode", "404");
        EmployeeError errorResponse = new EmployeeError(-1,"Golbal Failure",map);
    	return errorResponse;
    }*/
 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public EmployeeError exceptionHandler(MethodArgumentNotValidException ex) {
		Map<String,String> errors = new HashMap<String,String>();
		//errors.put("errorMessage", "Following reasons:");
	     ex.getBindingResult()
		      .getFieldErrors()
		      .forEach(error -> errors.put("errorMessage", error.getDefaultMessage()));
	     errors.put("errorCode", "500");
	     EmployeeError er = new EmployeeError(-1,"Validation Failure",errors);
		return er;
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PageNotFoundException.class)
	public EmployeeError pageNotFound(PageNotFoundException ex) {
		Map<String,String> errors = new HashMap<>();
		errors.put("errorMessage", "Page size should not be 0...Enter value greater than 0...");
		errors.put("errorCode", "404");
		return new EmployeeError(-1,"Validation Failure",errors);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ValueNotFoundException.class)
	public EmployeeError valueNotFound(ValueNotFoundException ex) {
		Map<String,String> errors = new HashMap<>();
		errors.put("errorMessage", "No detail found for this value you entered...Try other one...");
		errors.put("errorCode", "404");
		return new EmployeeError(-1,"Failure",errors);
	}

}
