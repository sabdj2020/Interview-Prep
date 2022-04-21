package com.example.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo=employeeRepo;
	}
	
	public Employee addEmployee(Employee e) {
		e.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(e) ;
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee findEmployeeById(Long id) throws UserNotFoundException {
		return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("user"+id+"not found"));
	}
	
	public Employee updateEmplyee(Employee e) {
		return employeeRepo.save(e);
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

}
