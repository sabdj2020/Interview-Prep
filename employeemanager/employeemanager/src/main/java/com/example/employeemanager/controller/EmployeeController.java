package com.example.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")    //base url
public class EmployeeController {
	
	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
		}
	
	
	@GetMapping("/find/id")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws UserNotFoundException{
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updatedEmployee = employeeService.updateEmplyee(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/id")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}

// testing using postman 

/*
 * What is Jackson in spring boot?
Jackson. Jackson is a suite of data-processing tools for Java. It allows to read and write data in JSON, Avro, BSON, CBOR, CSV, Smile, (Java) Properties, Protobuf, XML or YAML format. Jackson is auto-configured. It comes with the spring-boot-starter-json .*/
