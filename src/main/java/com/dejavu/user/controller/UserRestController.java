package com.dejavu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dejavu.user.model.User;
import com.dejavu.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{userId}")
	public User findById(@PathVariable Integer userId) {
		return userService.findByUserId(userId);
	}
	
}
