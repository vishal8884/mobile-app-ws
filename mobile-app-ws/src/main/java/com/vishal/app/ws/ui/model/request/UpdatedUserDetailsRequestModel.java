package com.vishal.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdatedUserDetailsRequestModel {

	@NotNull(message = "first name cannot be null")
	@Size(min = 3, message = "name size should be greater than 5")
	private String firstName;
	@NotNull(message = "last name cannot be null")
	private String lastName;
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
	
	
	
}
