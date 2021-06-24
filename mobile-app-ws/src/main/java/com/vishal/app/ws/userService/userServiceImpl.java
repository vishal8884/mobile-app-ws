package com.vishal.app.ws.userService;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishal.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vishal.app.ws.ui.model.response.UserRest;
import com.vishal.app.ws.utils.Utils;

@Service
public class userServiceImpl implements userService{
	
	
	Utils utils;
	
	
	public userServiceImpl()
	{
		
	}
	@Autowired                             //this autowired helps us to create the instance of utils class which is used in getUserRest
	public userServiceImpl(Utils utils)   // constructor injection during using autowired to create this method using interface
	{
		this.utils=utils;
	}

	@Override
	public UserRest getUserRest(UserDetailsRequestModel userDetailsRequestModel) {
		
		UserRest returnValue = new UserRest();
		
		returnValue.setFirstName(userDetailsRequestModel.getFirstName());
		returnValue.setLastName(userDetailsRequestModel.getLastName());
		returnValue.setEmail(userDetailsRequestModel.getEmail());
		
		//String userId=UUID.randomUUID().toString();  //even userId can be sent from postman
		
		String userId=utils.generateUtils();
		
		returnValue.setId(userId);
		
		
		
		return returnValue;
	}

}
