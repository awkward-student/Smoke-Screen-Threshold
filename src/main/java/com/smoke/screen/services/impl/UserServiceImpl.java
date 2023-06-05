package com.smoke.screen.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoke.screen.entities.User;
import com.smoke.screen.exceptions.ResourceNotFoundException;
import com.smoke.screen.payloads.UserDTO;
import com.smoke.screen.repos.UserRepo;
import com.smoke.screen.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setBranch(userDto.getBranch());
		user.setSem(userDto.getSem());

		User updatedUser = this.userRepo.save(user);
		UserDTO updatedUserDto = this.userToDto(updatedUser);
		return updatedUserDto;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDTO userDTO) {
		User user = this.modelMapper.map(userDTO, User.class);
		return user;
	}

	public UserDTO userToDto(User user) {
		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);
		return userDto;
	}

}