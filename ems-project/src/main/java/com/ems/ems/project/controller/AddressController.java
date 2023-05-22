package com.ems.ems.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.exception.Response;
import com.ems.ems.project.model.Address;
import com.ems.ems.project.model.Employee;
import com.ems.ems.project.service.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/address")
public class AddressController {
	
	private AddressService service;
	
	public AddressController(AddressService service) {
		super();
		this.service = service;
	}
	
	  @PostMapping("/{id}")
	  public Response saveAddress(@PathVariable long id, @RequestBody Address address) {
	       return service.saveAddress(id,address);
	   }
	  
	  
	  @PutMapping("/{id}")
	  public EmployeeError updateAddress(@PathVariable long id, @RequestBody Address address) {
	       return service.updateAddress(id,address);
	   }
	  
	  @DeleteMapping("/{id}")
	  public EmployeeError deleteAddress(@PathVariable long id) {
	       return service.deleteAddress(id);
	   }
	  
	 
}
