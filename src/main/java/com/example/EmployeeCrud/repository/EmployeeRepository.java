package com.example.EmployeeCrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeCrud.domain.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	

	
	
}
