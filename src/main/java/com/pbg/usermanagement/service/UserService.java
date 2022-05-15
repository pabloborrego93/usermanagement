package com.pbg.usermanagement.service;

import java.util.Set;

import com.pbg.usermanagement.dto.UserDto;

public interface UserService {

	UserDto findById(Long id) throws Exception;

	Set<UserDto> findAll();
	
}