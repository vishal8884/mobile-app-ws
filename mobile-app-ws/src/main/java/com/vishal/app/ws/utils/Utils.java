package com.vishal.app.ws.utils;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	
	
	public String generateUtils()
	{
		return UUID.randomUUID().toString();
	}

}
