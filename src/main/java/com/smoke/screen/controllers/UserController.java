package com.smoke.screen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoke.screen.payloads.UserDTO;
import com.smoke.screen.services.UserService;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO createUserDto = this.userService.createUser(userDTO);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
}
