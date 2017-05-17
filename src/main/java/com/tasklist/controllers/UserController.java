package com.tasklist.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.implementation.UserServiceImpl;
import com.tasklist.services.requestmodels.UserLoginReqModel;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

@RestController(value="/api")
public class UserController {

	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/register")
	public UserDTO register(@RequestBody UserRegisterReqModel model){
		
	}
	
	@PostMapping(value="/login")
	public UserDTO login(@RequestBody UserLoginReqModel model){
		
	}
	
	@PostMapping(value="/logout")
	public void logout(){
		
	}
}
