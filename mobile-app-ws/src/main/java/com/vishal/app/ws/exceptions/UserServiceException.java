package com.vishal.app.ws.exceptions;

public class UserServiceException extends RuntimeException{    //this is own type of exception create by us

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserServiceException(String message)
	{
		super(message);
	}

}
