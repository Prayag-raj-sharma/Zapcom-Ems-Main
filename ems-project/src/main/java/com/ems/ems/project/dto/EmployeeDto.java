package com.ems.ems.project.dto;

public class EmployeeDto {

	private Long id;
	private String emailId;
	private String firstName;
	private String lastName;
	
	public EmployeeDto() {
		
	}
	
	public EmployeeDto(Long id, String emailId, String firstName, String lastName) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	
}
