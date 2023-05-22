package com.ems.ems.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.ems.project.dto.EmployeeDetailDto;
import com.ems.ems.project.model.Address;

public interface AddressRepo extends JpaRepository<Address,Long> {

    


}
