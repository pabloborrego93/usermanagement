package com.pbg.usermanagement.service;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.pbg.usermanagement.dto.UserDto;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Set<UserDto> USER_DB = new TreeSet<>(
		Set.of(
			UserDto.builder().id(1L).email("testemail1@gmail.com").build(),
			UserDto.builder().id(2L).email("testemail2@gmail.com").build(),
			UserDto.builder().id(3L).email("testemail3@gmail.com").build(),
			UserDto.builder().id(4L).email("testemail4@gmail.com").build()
		)
	);
	
	@Override
	public UserDto findById(Long id) throws Exception {
		Optional<UserDto> optUserDto = USER_DB.stream().filter(userDto -> userDto.getId().equals(id)).findFirst();
		if(optUserDto.isPresent()) {
			return optUserDto.get();
		} else {
			String errorMessage = String.format("User with id %s not found", id);
			throw new Exception(errorMessage);
		}
	}

	@Override
	public Set<UserDto> findAll() {
		return USER_DB;
	}

}
