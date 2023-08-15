package com.greatlearning.emra.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.emra.entity.Employee;


public interface EmployeeService {
	
	Employee addEmployees(Employee employee);

	List<Employee> listAllEmployees();

	Employee getEmployeeById(Integer id);

	Object deleteEmployeeById(Integer id);

	List<Employee> getEmployeesSortedByName(Direction direction);

	List<Employee> findByFirstName(String firstName);


}
