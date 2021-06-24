package com.vishal.app.ws.ui.controller;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.app.ws.ui.model.request.UpdatedUserDetailsRequestModel;
import com.vishal.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vishal.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")  // http://localhost:8080/users
public class UserController {
	
	
	HashMap<String, UserRest> users;                                                                     // This is like temp database
	
	@GetMapping  
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			               @RequestParam(value = "limit", defaultValue = "10") int limit,
			               @RequestParam(value = "sort",required = false) String sort
			)                                                                                                          //requestparam is used to get query(after ?) parameters which needs to passed in post man ------->  (http://localhost:8080/users?page=94&limit=7)
	{
		return "get user was called with page --> "+page+"  and limit --> "+limit+"    and sort --> "+sort;
	}
	
	@GetMapping(path = "/{userId}" , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})    // http://localhost:8080/users/{userId}
	public ResponseEntity<UserRest> getUser(@PathVariable String userId)                                                               //path variable is used to get uri paramenter
	{
		
		
		
		if(users.containsKey(userId))
		{
			UserRest getFromPost = users.get(userId);
			return new ResponseEntity<UserRest>(getFromPost,HttpStatus.OK);    //users.get(userId)
		}
		else
		{
			return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);  //for returning status code
		}
		
		                                                        
	}
	
	
//	@GetMapping(path = "/{userId}" , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})    // http://localhost:8080/users/{userId}
//	public ResponseEntity<UserRest> getUser(@PathVariable String userId)                                                               //path variable is used to get uri paramenter
//	{
//		UserRest userRest = new UserRest();
//		
//		userRest.setId(userId);
//		userRest.setFirstName("vishal");
//		userRest.setLastName("N");
//		userRest.setEmail("vishal@gmail.com");
//		
//		return new ResponseEntity<UserRest>(userRest,HttpStatus.OK);                                                           //for returning status code
//	}
	
//	@GetMapping(path = "/{userId}" , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})    // http://localhost:8080/users/{userId}
//	public UserRest getUser(@PathVariable String userId)                                                               //path variable is used to get uri paramenter
//	{
//		UserRest userRest = new UserRest();
//		
//		userRest.setId(userId);
//		userRest.setFirstName("vishal");
//		userRest.setLastName("N");
//		userRest.setEmail("vishal@gmail.com");
//		
//		return userRest;
//	}
	
//	@GetMapping(path = "/{userId}")   // http://localhost:8080/users/{userId}
//	public String getUser(@PathVariable String userId)                               //path variable is used to get uri paramenter
//	{
//		return "get user was called with user Id :: "+userId;
//	}
	
	
	//////////////////////////////////////////////////////post Mapping /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> CreateUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) //gets the data from postMapping in postman app with url(http://localhost:8080/users)  --------- json --> {"firstName" : "vishal","lastName":"N", "email" : "vishal@xox.com", "password" : "abcd1234"}
	{
		UserRest returnValue = new UserRest();
		
		//System.out.println("test :: "+userDetailsRequestModel.getEmail());
		
		returnValue.setFirstName(userDetailsRequestModel.getFirstName());
		returnValue.setLastName(userDetailsRequestModel.getLastName());
		returnValue.setEmail(userDetailsRequestModel.getEmail());
		
		String userId=UUID.randomUUID().toString();  //even userId can be sent from postman
		returnValue.setId(userId);
		
		if(users==null)                              //wprks without this if condition also
		{
			users= new HashMap<String, UserRest>();
			users.put(userId, returnValue);
		}
		
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}
	
	
//	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
//	public UserRest CreateUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel)
//	{
//		UserRest returnValue = new UserRest();
//		
//		//System.out.println("test :: "+userDetailsRequestModel.getEmail());
//		
//		returnValue.setFirstName(userDetailsRequestModel.getFirstName());
//		returnValue.setLastName(userDetailsRequestModel.getLastName());
//		returnValue.setEmail(userDetailsRequestModel.getEmail());
//		
//		return returnValue;
//	}
	
	
	////////////////////////////////////put mapping//////////////////////////////////////////////////////////// 
	
	@PutMapping(path = "/{userId}" ,consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> UpdateUser(@PathVariable String userId, @RequestBody UpdatedUserDetailsRequestModel updatedUserDetailsRequestModel)
	{
		UserRest updatedUserRest = users.get(userId);
		updatedUserRest.setFirstName(updatedUserDetailsRequestModel.getFirstName());
		updatedUserRest.setLastName(updatedUserDetailsRequestModel.getLastName());
		
		users.put(userId, updatedUserRest);
		

		return new ResponseEntity<UserRest>(updatedUserRest,HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> DeleteUser(@PathVariable String userId)
	{
//		String s= null;
//		int len = s.length();  //to test null pointer exception
		
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
	

}
