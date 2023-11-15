package com.blog.krishna.services;

import java.util.List;

import com.blog.krishna.payloads.UserDto;

public interface UserServices {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

}
