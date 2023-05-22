package com.ems.ems.project.exception;

import java.util.HashMap;
import java.util.Map;

public class MapInput {

	private Map<String,String> error;
	
	public MapInput() {
		
	}

	public MapInput(Map<String, String> error) {
		super();
		this.error = error;
	}
	
	public void valueAdd(String a, String b) {
		error = new HashMap<String,String>();
		
		error.put(a, b);
	}
}
