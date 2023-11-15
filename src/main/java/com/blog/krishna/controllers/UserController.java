package com.blog.krishna.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.krishna.payloads.UserDto;
import com.blog.krishna.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserServices userService;
	
	@GetMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createData=this.userService.createUser(userDto);
		return new ResponseEntity<>(createData,HttpStatus.CREATED);
	}

}
