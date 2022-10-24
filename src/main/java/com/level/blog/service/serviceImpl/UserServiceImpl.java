package com.level.blog.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Null;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.level.blog.config.AppConstants;
import com.level.blog.entity.Role;
import com.level.blog.entity.User;
import com.level.blog.exception.ApiException;
import com.level.blog.exception.ResourceNotFoundException;
import com.level.blog.exception.SqlException;
import com.level.blog.payload.UserDto;
import com.level.blog.repository.RoleRepo;
import com.level.blog.repository.UserRepo;
import com.level.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId.toString()));
		user = this.modelMapper.map(userDto, User.class);
		User updatedUser = this.userRepo.save(user);
		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId.toString()));

		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId.toString()));
		this.userRepo.delete(user);

	}

	@Override
	public UserDto registerNewUser(UserDto userDto) throws Exception {
		User user = this.modelMapper.map(userDto, User.class);
		user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
//		if we found user with a same email then throw an exception
		Optional<User> ifExist = this.userRepo.findByEmail(userDto.getEmail());
		if (ifExist.isPresent()) {
			throw new SqlException("Email already exist");
		} else {
			User newUser = null;
			newUser = this.userRepo.save(user);
			if (newUser != null)
				return this.modelMapper.map(newUser, UserDto.class);
		}

		return userDto;
	}

}
