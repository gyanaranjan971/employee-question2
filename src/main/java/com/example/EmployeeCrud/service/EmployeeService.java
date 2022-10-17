package com.example.EmployeeCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeCrud.domain.Employee;
import com.example.EmployeeCrud.repository.EmployeeRepository;




@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	public List<Employee>listAll(){
		return repo.findAll();
	}
	public void save(Employee std) {
		repo.save(std);
	}
	public Employee get(long id) {
		return repo.findById(id).get();
	}
	
public void delete(long id) {
	repo.deleteById(id);
}
}