package com.ems.ems.project.service;

import java.util.List;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.exception.Response;
import com.ems.ems.project.model.Address;

public interface AddressService {

	Response saveAddress(long id, Address address);
	
	EmployeeError updateAddress(long id, Address address);
	
	EmployeeError deleteAddress(long id);
	
	
}
