package com.smoke.screen.services;

import java.util.List;

import com.smoke.screen.payloads.UserDTO;

public interface UserService {

//	For User
	UserDTO createUser(UserDTO userDto);
//	For Admin
	UserDTO updateUser(UserDTO userDto, Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
	
}