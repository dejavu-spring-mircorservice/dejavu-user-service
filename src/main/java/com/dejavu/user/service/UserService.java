package com.dejavu.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dejavu.user.model.User;
import com.dejavu.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User findByUserId(Integer userId) {
		return userRepository.findById(userId).orElse(null);
	}
}
