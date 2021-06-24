package com.vishal.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vishal.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{                        //THIS CLASS HANDLES EXCEPTION WHEN INVALID USERID IS PASSED

	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request)
	{
		
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if(errorMessageDescription==null)
			errorMessageDescription=ex.toString();
		
		ErrorMessage error = new ErrorMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex,WebRequest request)
	{
		
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if(errorMessageDescription==null)
			errorMessageDescription=ex.toString();
		
		ErrorMessage error = new ErrorMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(value = {Exception.class})
//	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request)
//	{
//		
//		
//		
//		return new ResponseEntity<>(ex,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}