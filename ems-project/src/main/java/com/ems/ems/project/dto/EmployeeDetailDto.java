package com.ems.ems.project.dto;

import java.util.List;

import com.ems.ems.project.model.Address;

import lombok.*;


public class EmployeeDetailDto {

	private String firstName;
	private String lastName;
	private String address;
	
	public EmployeeDetailDto() {
		
	}
	
	public EmployeeDetailDto(String firstName, String lastName, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
