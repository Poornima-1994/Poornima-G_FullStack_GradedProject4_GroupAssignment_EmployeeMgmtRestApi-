package com.greatlearning.emra.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.emra.entity.Employee;
import com.greatlearning.emra.repo.EmployeeRepo;
import com.greatlearning.emra.service.EmployeeService;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	// Adding new employee
	@Override
	public Employee addEmployees(Employee employee) {
		return employeeRepo.saveAndFlush(employee);
	}

	// Fetch all employees
	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepo.findAll();
	}

	// Fetch Employee by ID
	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> empolyees = employeeRepo.findById(id);
		return empolyees.get();
	}

	// Delete employee
	@Override
	public Object deleteEmployeeById(Integer id) {
		employeeRepo.deleteById(id);
		return "employee deleted with id";
	}

	// Sorted by name
	@Override
	public List<Employee> getEmployeesSortedByName(Direction direction) {

		return employeeRepo.findAll(Sort.by(direction, "firstName"));
	}

	// Fetch employee by first name
	@Override
	public List<Employee> findByFirstName(@RequestParam("firstName") String firstName) {
		if (firstName == null) {
			return employeeRepo.findAll();
		} else {
			return employeeRepo.findByFirstName(firstName);
		}

	}

}


