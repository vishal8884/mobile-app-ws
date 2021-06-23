package com.vishal.app.ws.ui.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.app.ws.ui.model.UserRest;

@RestController
@RequestMapping("users")  // http://localhost:8080/users
public class UserController {
	
	@GetMapping  
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "sort",required = false) String sort
			)                  //requestparam is used to get query(after ?) parameters which needs to passed in post man ------->  (http://localhost:8080/users?page=94&limit=7)
	{
		return "get user was called with page --> "+page+"  and limit --> "+limit+"    and sort --> "+sort;
	}
	
	@GetMapping(path = "/{userId}" , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})   // http://localhost:8080/users/{userId}
	public UserRest getUser(@PathVariable String userId)                               //path variable is used to get uri paramenter
	{
		UserRest userRest = new UserRest();
		
		userRest.setId(userId);
		userRest.setFirstName("vishal");
		userRest.setLastName("N");
		userRest.setEmail("vishal@gmail.com");
		
		return userRest;
	}
	
	
//	@GetMapping(path = "/{userId}")   // http://localhost:8080/users/{userId}
//	public String getUser(@PathVariable String userId)                               //path variable is used to get uri paramenter
//	{
//		return "get user was called with user Id :: "+userId;
//	}
	
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
