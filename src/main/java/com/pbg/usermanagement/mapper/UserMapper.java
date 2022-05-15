package com.pbg.usermanagement.mapper;

import com.pbg.usermanagement.dto.User;
import com.pbg.usermanagement.dto.UserDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDto toDto(User user);
	
}
