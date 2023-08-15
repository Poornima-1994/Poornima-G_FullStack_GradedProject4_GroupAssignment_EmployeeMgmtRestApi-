package com.greatlearning.emra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.emra.entity.Role;
import com.greatlearning.emra.service.RoleService;

@RestController
@RequestMapping("/api")

public class RoleController {
	
	@Autowired
	private RoleService roleService;

	// Add Role
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

}


