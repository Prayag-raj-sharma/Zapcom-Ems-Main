package com.ems.ems.project.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.dto.EmployeeDto;
import com.ems.ems.project.exception.EmployeeError;
import com.ems.ems.project.model.Employee;
import com.ems.ems.project.model.EmployeePage;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>, JpaRepository<Employee, Long> {

	// To get the details of the employee by first name from the database.
	Employee getByfirstName(String firstName); 
	
	// To get the details of the employee by last name from the database.
	Employee getBylastName(String lastName);
	
	
	// Native query is written here.
	@Query(value = "Select * from empl.employees e where e.last_name = :last_name",
			nativeQuery = true)
	List<Employee> getAllEmployeeByLastNameNative(@Param("last_name") String lastName);
	
	//JPQL query is written here.
	@Query("Select e from Employee e where e.firstName = ?1")
	List<Employee> getAllEmployeeByFirstName(String firstName);
	
	 @Query("Update Employee e set e.active = 0 where e.id = :id")
	 @Modifying
	 @Transactional
	 void deleteEmployeeById(@Param("id") long id);
	 
	 // join query to get the info
	 @Query(value = "select new com.ems.ems.project.dto.EmployeeDetailDto(e.firstName,e.lastName,a.address) from Employee e join e.addresses as a")
	 List<EmployeeDetailDto> getDetailsOfEmployee();
     
	 
	 
	@Query("select new com.ems.ems.project.dto.EmployeeDetailDto(e.firstName,e.lastName,a.address) from Employee e join e.addresses as a where e.firstName = :firstName")
	List<EmployeeDetailDto> findByFirstName(String firstName);
	

}
