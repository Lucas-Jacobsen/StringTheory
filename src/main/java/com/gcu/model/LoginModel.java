package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//login model for the login on the welcome.html page
public class LoginModel 
{
	//errors on the username
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String username; 

	//errors on the password
	@NotNull(message="Password is required field")
	@Size(min=1, max=32, message="Password must be between 1-32 characters")
	private String password;
	
	
	//getters and setters for username and password
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public LoginModel() {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
