package com.blog.krishna.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.krishna.entities.User;
import com.blog.krishna.payloads.UserDto;
import com.blog.krishna.resposities.UserRepo;
import com.blog.krishna.services.UserServices;
import com.blog.krishna.exceptions.*;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.dtoToUser(userDto);
		User saveUser=this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		//ResourceNotFoundException resource=new ResourceNotFoundException("User", "Id", userId);
		User userfind=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		userfind.setName(userDto.getName());
		userfind.setEmail(userDto.getEmail());
		userfind.setPassowrd(userDto.getPassowrd());
		userfind.setAbout(userDto.getAbout());
		User updateUser=this.userRepo.save(userfind);
		
		return this.userToDto(updateUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDto=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User userDelete=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(userDelete);

	}
	private User dtoToUser(UserDto userDto)
	{
	 return this.modelMapper.map(userDto, User.class);
//	 User user=new User();
//	 user.setId(userDto.getId());
//	 user.setName(userDto.getName());
//	 user.setEmail(userDto.getEmail());
//	 user.setPassowrd(userDto.getPassowrd());
//	 user.setAbout(userDto.getAbout());
//	 return user;
	}
	
	private UserDto userToDto(User user)
	{
//	 UserDto userDto=new UserDto();
//	 userDto.setId(user.getId());
//	 userDto.setName(user.getName());
//	 userDto.setEmail(user.getEmail());
//	 userDto.setPassowrd(user.getPassowrd());
//	 userDto.setAbout(user.getAbout());
//     return userDto;
	 return this.modelMapper.map(user, UserDto.class);
	}

}
