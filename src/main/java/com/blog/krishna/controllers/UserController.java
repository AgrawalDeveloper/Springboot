package com.blog.krishna.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.krishna.payloads.ApiResponse;
import com.blog.krishna.payloads.UserDto;
import com.blog.krishna.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createData=this.userService.createUser(userDto);
		return new ResponseEntity<>(createData,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable int userId)
	{
		UserDto updateData=this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updateData,HttpStatus.ACCEPTED);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getdataById(@PathVariable int userId)
	{
		UserDto getData=this.userService.getUserById(userId);
		return new ResponseEntity<>(getData,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllData()
	{
		
		return  ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId)
	{
		this.userService.deleteUser(userId);
		//return new ResponseEntity<>(Map.of("message","User deleted successfully"),HttpStatus.OK);
		return new ResponseEntity<>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}

}
