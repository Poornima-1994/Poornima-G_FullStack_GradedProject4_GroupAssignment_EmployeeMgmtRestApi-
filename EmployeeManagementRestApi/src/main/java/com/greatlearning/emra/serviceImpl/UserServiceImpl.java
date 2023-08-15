package com.greatlearning.emra.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.greatlearning.emra.entity.User;
import com.greatlearning.emra.repo.UserRepo;
import com.greatlearning.emra.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

}