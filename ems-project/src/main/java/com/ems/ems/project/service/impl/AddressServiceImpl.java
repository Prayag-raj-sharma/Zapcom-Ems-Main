package com.ems.ems.project.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.exception.AddressNotFoundException;
import com.ems.ems.project.exception.DeleteNotFoundException;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.exception.ResourceNotFoundException;
import com.ems.ems.project.exception.Response;
import com.ems.ems.project.exception.UpdateNotFoundException;
import com.ems.ems.project.model.Address;
import com.ems.ems.project.model.Employee;
import com.ems.ems.project.repo.AddressRepo;
import com.ems.ems.project.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepo repo;
	
	public AddressServiceImpl(AddressRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Response saveAddress(@Param("id") long id, Address address) {
		
		    //repo.findById(id).orElseThrow(() ->
			//new AddressNotFoundException("NULL"));
		
		    Address add = repo.save(address);
			return new Response(add.getId(),"Address added successfully !!!");
		
	}

	@Override
	public EmployeeError updateAddress(long id, Address address) {
		
		Address existingAddress = repo.findById(id).orElseThrow(
				() -> new UpdateNotFoundException("Error")); 
		
		existingAddress.setAddress(address.getAddress());
		
		// save existing employee to database
		repo.save(existingAddress);
		return new EmployeeError(existingAddress.getId(),"Success!!! Address get updated..",null);

	}

	@Override
	public EmployeeError deleteAddress(long id) {
		Address address = repo.findById(id).orElseThrow(() -> 
		new DeleteNotFoundException(""));
		
        repo.delete(address);
        return new EmployeeError(address.getId(),"Success!!! Address Deleted...",null);
		
		
	}
	

	


}
