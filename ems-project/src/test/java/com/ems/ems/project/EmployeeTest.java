package com.ems.ems.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ems.ems.project.controller.EmployeeController;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.exception.ErrorResponse;
import com.ems.ems.project.exception.Response;
import com.ems.ems.project.model.Employee;
import com.ems.ems.project.model.EmployeePage;
import com.ems.ems.project.repo.EmployeeRepo;
import com.ems.ems.project.service.EmployeeService;
import com.ems.ems.project.service.impl.EmployeeServiceImpl;
import static org.mockito.BDDMockito.*;

public class EmployeeTest {

    @Mock
    private EmployeeService employeeService;
    // Service
    private EmployeeRepo repo;
 

    @InjectMocks
    private EmployeeController employeeController;
    // Service
    private EmployeeServiceImpl service;
    private Employee employee;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
       
    }

    @Test
    void testGetAllEmployees() {
        // Create a list of employees for testing
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John", "Doe", "john.doe@example.com",1));
        employees.add(new Employee(2L, "Jane", "Doe", "jane.doe@example.com",0));

        // Create a page of employees for testing
        Page<Employee> employeePage = new PageImpl<>(employees, PageRequest.of(0, 2, Sort.by("id")), 2);
        
        EmployeePage page = new EmployeePage(1,2,"id");

        // Mock the service method to return the page of employees
        when(employeeService.getAllEmployees(PageRequest.of(1, 2, Sort.by("id")))).thenReturn(employeePage);
        
        

        // Call the controller method and check the response
        Page<Employee> response = employeeController.getAllEmployees(1,2,"id");
        assertEquals(employeePage, response);

        // Verify that the service method was called once with the correct arguments
        verify(employeeService, times(1)).getAllEmployees(PageRequest.of(1, 2, Sort.by("id")));
        
       
    }

    @Test
    void testSaveEmployee() {
        // Create an employee for testing
        Employee employee = new Employee(1L, "John", "Cena", "john@gmail.com",1);
        Employee employee1 = new Employee(2L, "John"," ","john@gmail.com",1);
        Employee employee2 = new Employee(3L, "John","Cena","",1);
        Employee employee3 = new Employee(4L, "","Cena ","john@gmail.com",1);
        //Employee employee4 = new Employee(-4L, "John","Cena ","john@gmail.com",1);
        
        // Map
        //Map<String,String> map = new HashMap<>(null); 
        
        Map<String,String> map1 = new HashMap<>();
        map1.put("errorCode", "500");
        map1.put("errorMessage","last name should have atleast 2 characters");
        
        Map<String,String> map2 = new HashMap<>();
        map1.put("errorCode", "500");
        map1.put("errorMessage","email should not be blank...Add your email here...");
        
        Map<String,String> map3 = new HashMap<>();
        map1.put("errorCode", "500");
        map1.put("errorMessage","first name should have atleast 2 characters");
        
        
        // Responses
        EmployeeError response = new EmployeeError(1L,"Success!!! Employee added successfully...",null);
        EmployeeError response1 = new EmployeeError(-1L,"Validation Failure",map1);
        EmployeeError response2 = new EmployeeError(-1L,"Validation Failure",map2);
        EmployeeError response3 = new EmployeeError(-1L,"Validation Failure",map3);
        

        // Mock the service method to return the saved employee
        when(employeeService.saveEmployee(employee)).thenReturn(response);
        when(employeeService.saveEmployee(employee1)).thenReturn(response1);
        when(employeeService.saveEmployee(employee2)).thenReturn(response2);
        when(employeeService.saveEmployee(employee3)).thenReturn(response3);
        

        // Call the controller method and check the response
        EmployeeError r = employeeController.saveEmployee(employee);
        //assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(r, response);
        
        EmployeeError r1 = employeeController.saveEmployee(employee1);
        //assertEquals(HttpStatus.CREATED, response1.getStatusCode());
        assertEquals(r1, response1);
        
        EmployeeError r2 = employeeController.saveEmployee(employee2);
        //assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(r2, response2);
        
        EmployeeError r3 = employeeController.saveEmployee(employee3);
        //assertEquals(HttpStatus.CREATED, response1.getStatusCode());
        assertEquals(r3, response3);

        // Verify that the service method was called once with the correct argument
        verify(employeeService, times(1)).saveEmployee(employee);
        verify(employeeService, times(1)).saveEmployee(employee1);
        verify(employeeService, times(1)).saveEmployee(employee2);
        verify(employeeService, times(1)).saveEmployee(employee3);
    }

   
    
    @Test
    void deleteEmployee() {
    	
    	EmployeeError response1 = new EmployeeError(1L,"Success!!! Employee Deleted...",null);
    	
    	Map<String,String> map = new HashMap<>();
        map.put("errorCode", "404");
        map.put("errorMessage","Employee of this empId is not present..Try other one..");
        
    	EmployeeError response2 = new EmployeeError(-1L,"Failure",map);
       
        EmployeeError r1 = employeeController.deleteEmployee(1L);
        EmployeeError r2 = employeeController.deleteEmployee(103L);

       
        
        
        verify(employeeService, times(2)).deleteEmployee(anyLong());
    }
    
    @Test
    void getEmployeeById() {
        
        Employee employee = new Employee(1L, "John", "Cena", "john@gmail.com",1);
        when(employeeService.getEmployeeById(anyLong())).thenReturn(employee);

        
        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
        verify(employeeService, times(1)).getEmployeeById(anyLong());
    }
    
    @Test
    void getEmployeeByFirstName() {
        
        Employee employee = new Employee(1L, "John", "Cena", "john@gmail.com",1);
        when(employeeService.getEmployeeByFirstName(any())).thenReturn(employee);

        
        ResponseEntity<Employee> response1 = employeeController.getEmployeeByFirstName("John");
        ResponseEntity<Employee> response2 = employeeController.getEmployeeByFirstName("");

        
        assertEquals(HttpStatus.OK, response1.getStatusCode());
        assertEquals(HttpStatus.OK, response2.getStatusCode());
        
        assertEquals(employee, response1.getBody());
        assertEquals(employee, response2.getBody());
        verify(employeeService, times(2)).getEmployeeByFirstName(any());
    }
    
    @Test
    void getEmployeeByLastName() {
        
        Employee employee = new Employee(1L, "John", "Cena", "john@gmail.com",1);
        when(employeeService.getEmployeeByLastName(any())).thenReturn(employee);

        
        ResponseEntity<Employee> response1 = employeeController.getEmployeeByLastName("Cena");
        ResponseEntity<Employee> response2 = employeeController.getEmployeeByLastName("stark");

        
        assertEquals(HttpStatus.OK, response1.getStatusCode());
        assertEquals(HttpStatus.OK, response2.getStatusCode());
        
        assertEquals(employee, response1.getBody());
        assertEquals(employee, response2.getBody());
        verify(employeeService, times(2)).getEmployeeByLastName(any());
    }

   @Test
    void updateEmployee() {
        
        Employee employee = new Employee(1L, "John", "Cena", "john@gmail.com",1);
        
        
        EmployeeError response = new EmployeeError(1L,"Success!!! Employee details get updated..",null);
        
        when(employeeService.updateEmployee(any(Employee.class), anyLong())).thenReturn(response);
        
        EmployeeError r1 = employeeController.updateEmployee(1L, employee);

        
        //assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(r1, response);
        verify(employeeService, times(1)).updateEmployee(any(Employee.class), anyLong());
    }
    
    
}




    
    // Service Layer
    
 






