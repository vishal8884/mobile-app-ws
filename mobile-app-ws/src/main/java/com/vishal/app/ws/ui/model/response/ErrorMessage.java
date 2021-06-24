package com.vishal.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {
	
	public ErrorMessage()
	{
		
	}
	
	public ErrorMessage(Date date,String message)
	{
		this.date=date;
		this.message=message;
	}
	
	private Date date;
	private String message;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
