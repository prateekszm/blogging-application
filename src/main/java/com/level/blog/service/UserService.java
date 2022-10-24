package com.level.blog.service;

import java.util.List;

import com.level.blog.payload.UserDto;


public interface UserService {
	UserDto registerNewUser(UserDto user) throws Exception;
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
