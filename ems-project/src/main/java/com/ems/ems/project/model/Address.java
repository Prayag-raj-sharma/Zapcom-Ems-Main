package com.ems.ems.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name="employees_address")
public class Address {

	@Id
	private long id;
	
	@NotNull
	@NotBlank(message = "Required to enter address!!!")
	@Size(min = 3)
	private String address;
	
	public Address() {
		
	}

	public Address(long id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
