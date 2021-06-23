package com.vishal.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotNull(message = "first name cannot be null")
	@Size(min = 3, message = "name size should be greater than 5")
	private String firstName;
	@NotNull(message = "last name cannot be null")
	private String lastName;
	@NotNull(message = "emailcannot be null")
	@Email
	private String email;
	@NotNull(message = "password cannot be null")
	@Size(min = 5 , message = "password length is less than 5")
	private String password;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
 