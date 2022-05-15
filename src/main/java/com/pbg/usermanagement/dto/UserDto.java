package com.pbg.usermanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class UserDto implements Comparable <UserDto> {

	private Long id;
	@EqualsAndHashCode.Exclude private String email;
	
	@Override
	public int compareTo(UserDto userDto) {
		return this.id.compareTo(userDto.getId());
	}
	
}
