package com.greatlearning.emra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.emra.entity.Employee;

@Repository

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	List<Employee> findByFirstName(String firstName);

}
