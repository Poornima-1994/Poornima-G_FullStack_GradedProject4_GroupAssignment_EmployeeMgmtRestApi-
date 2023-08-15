package com.greatlearning.emra.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.emra.entity.Role;
import com.greatlearning.emra.repo.RoleRepo;
import com.greatlearning.emra.service.RoleService;

@Service

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

}
