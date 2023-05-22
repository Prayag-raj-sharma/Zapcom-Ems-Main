package com.ems.ems.project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.dto.EmployeeDto;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.exception.Response;
import com.ems.ems.project.model.Employee;



public interface EmployeeService {
	
	EmployeeError saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	EmployeeError updateEmployee(Employee employee, long id);
	
	// Soft delete
	EmployeeError deleteEmployee(long id);
	
    Page<Employee> getAllEmployees(Pageable pageable);
	
	Employee getEmployeeByFirstName(String firstName);
	
	Employee getEmployeeByLastName(String lastName);
	
	// JPQL query 
	List<Employee> getAllEmployeeByFirstName(String firstName);
    
	// Native Query
	List<Employee> getAllEmployeeByLastNameNative(String lastName);
	
	EmployeeDto convertEntityToDto(Employee employee);
	
	Employee convertDtoToEntity(EmployeeDto dto);
	
	List<EmployeeDto> getAllEmployeesList();
	
	//Join Values
	List<EmployeeDetailDto> getDetailsOfEmployee();
	
	List<EmployeeDetailDto> getAddressByFirstName(String firstName);
	
}
