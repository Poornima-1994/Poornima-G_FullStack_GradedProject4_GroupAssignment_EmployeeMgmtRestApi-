package com.greatlearning.emra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
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

import com.greatlearning.emra.entity.Employee;
import com.greatlearning.emra.service.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceImpl;

	// Fetch All Employee
	@GetMapping("/listAllEmployees")
	public List<Employee> listAllEmployees() {
		return employeeServiceImpl.listAllEmployees();
	}

	// Sort employee by Name
	@GetMapping("/getEmployeesSortedByName")
	public List<Employee> getEmployeesSortedByName(Direction direction) {
		return employeeServiceImpl.getEmployeesSortedByName(direction);
	}

	// Fetch Employee by ID
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getUserById(@PathVariable("id") Integer id) {
		Employee employee = employeeServiceImpl.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	// Fetch employee by First Name
	@GetMapping("/searchByFirstName")
	public List<Employee> searchByFirstName(String firstName) {
		return employeeServiceImpl.findByFirstName(firstName);
	}

	// Add Employee
	@PostMapping("/addNewEmployee")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.addEmployees(employee);
	}

	// Delete Employee by ID
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
		employeeServiceImpl.deleteEmployeeById(id);
		return new ResponseEntity<>("User ID " + id + " has been successfully deleted!", HttpStatus.OK);
	}

	// Update Employee
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.addEmployees(employee);
	}


}
