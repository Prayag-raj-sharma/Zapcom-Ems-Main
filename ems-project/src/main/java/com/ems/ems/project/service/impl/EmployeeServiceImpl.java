package com.ems.ems.project.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.dto.EmployeeDto;
import com.ems.ems.project.exception.DeleteNotFoundException;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.exception.ErrorDetails;
import com.ems.ems.project.exception.ErrorResponse;
import com.ems.ems.project.exception.PageNotFoundException;
import com.ems.ems.project.exception.ResourceNotFoundException;
import com.ems.ems.project.exception.Response;
import com.ems.ems.project.exception.UpdateNotFoundException;
import com.ems.ems.project.exception.ValueNotFoundException;
import com.ems.ems.project.model.Employee;
import com.ems.ems.project.repo.EmployeeRepo;
import com.ems.ems.project.service.EmployeeService;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
	private EmployeeRepo repo;
    
    @Autowired
    private ModelMapper modelMapper;
	
	ErrorDetails ed = new ErrorDetails();
	
	public EmployeeServiceImpl(EmployeeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public EmployeeError saveEmployee(Employee employee) {
		if(employee == null || employee.getId() < 0){
			throw new ResourceNotFoundException("NULL");
		}
		else {
			Employee empl = repo.save(employee);
			return new EmployeeError(empl.getId(),"Success!!! Employee added successfully...",null);
		}
		
	}
	
	@Override
	public List<EmployeeDto> getAllEmployeesList() {
		return repo.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
        return repo.findAll(pageable);
        		
	}

	@Override
	public Employee getEmployeeByFirstName(String firstName) {
		return repo.getByfirstName(firstName);
	}
	
	@Override
	public Employee getEmployeeByLastName(String lastName) {
		return repo.getBylastName(lastName);
	}

	@Override
	public Employee getEmployeeById(long id) {
		return repo.findById(id).orElseThrow(() -> 
		new ValueNotFoundException("No Data To Show For This Particular ID, Try Other One !!!"));
	}

	@Override
	public EmployeeError updateEmployee(Employee employee, long id) {
				Employee existingEmployee = repo.findById(id).orElseThrow(
						() -> new UpdateNotFoundException("Error")); 
				
				existingEmployee.setEmailId(employee.getEmailId());
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setActive(employee.getActive());
				
				// save existing employee to database
				repo.save(existingEmployee);
				return new EmployeeError(existingEmployee.getId(),"Success!!! Employee details get updated..",null);
	}

	@Override
	public EmployeeError deleteEmployee(long id) {
		Employee emp = repo.findById(id).orElseThrow(() -> 
		new DeleteNotFoundException(""));
		
        repo.deleteEmployeeById(id);
        return new EmployeeError(id,"Success!!! Employee Deleted...",null);
		
	}

	@Override
	public List<Employee> getAllEmployeeByFirstName(String firstName) {
		
		return repo.getAllEmployeeByFirstName(firstName);
	}
	
	@Override
	public List<Employee> getAllEmployeeByLastNameNative(String lastName) {
		
		return repo.getAllEmployeeByLastNameNative(lastName);
	}

	@Override
	public EmployeeDto convertEntityToDto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto = modelMapper.map(employee, EmployeeDto.class);
		return dto;
	}
	
	@Override
	public Employee convertDtoToEntity(EmployeeDto dto) {
		Employee employee = new Employee();
		employee = modelMapper.map(dto, Employee.class);
		return employee;
	}

	@Override
	public List<EmployeeDetailDto> getDetailsOfEmployee() {
		return repo.getDetailsOfEmployee();
	}

	@Override
	public List<EmployeeDetailDto> getAddressByFirstName(String firstName) {
		
		return repo.findByFirstName(firstName);
	}

}




 
