package com.greatlearning.utility;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.emra.entity.Employee;
import com.greatlearning.emra.entity.Role;
import com.greatlearning.emra.entity.User;
import com.greatlearning.emra.repo.EmployeeRepo;
import com.greatlearning.emra.repo.RoleRepo;
import com.greatlearning.emra.repo.UserRepo;

@Configuration

public class BootStrapAppData {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private RoleRepo roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public BootStrapAppData(EmployeeRepo employeeRepo, UserRepo userRepository, PasswordEncoder passwordEncoder) {
		this.employeeRepo = employeeRepo;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	//  employees
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void usersData(ApplicationReadyEvent readyEvent) {

		Employee Poornima = new Employee("Poornima", "Gukanti", "poornima@gmail.com");
		Employee Somalina = new Employee("Somalina", "Chakraborty", "somalina@gmail.com");
		Employee Raj = new Employee("Rajdeep", "Roy", "Raj@gmail.com");

		this.employeeRepo.save(Poornima);
		this.employeeRepo.save(Somalina);
		this.employeeRepo.save(Raj);

	}

	//  users
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void insertAllData(ApplicationReadyEvent event) {
		User Michael = new User("Koshal", passwordEncoder.encode("Koshal"));
		User admin = new User("admin", passwordEncoder.encode("admin"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");

		roleRepository.saveAndFlush(userRole);
		roleRepository.saveAndFlush(adminRole);

		admin.addRole(adminRole);
		Michael.addRole(userRole);

		userRepository.saveAndFlush(Koshal);
		userRepository.saveAndFlush(admin);

	}

}
