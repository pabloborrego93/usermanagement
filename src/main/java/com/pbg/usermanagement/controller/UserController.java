package com.pbg.usermanagement.controller;

import java.util.Set;

import com.pbg.usermanagement.dto.UserDto;
import com.pbg.usermanagement.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public UserDto findById(@PathVariable Long id) throws Exception {
		return userService.findById(id);
	}

	@GetMapping
	public Set<UserDto> findAll() {
		return userService.findAll();
	}
	
}
