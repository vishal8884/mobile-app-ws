package com.vishal.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")  // http://localhost:8080/users
public class UserController {
	
	@GetMapping(path = "/{userId}")   // http://localhost:8080/users/{userId}
	public String getUser(@PathVariable String userId)
	{
		return "get user was called with user Id :: "+userId;
	}
	
	@PostMapping
	public String CreateUser()
	{
		return "create user was called";
	}
	
	@PutMapping
	public String UpdateUser()
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String DeleteUser()
	{
		return "delete user was called";
	}
	

}
