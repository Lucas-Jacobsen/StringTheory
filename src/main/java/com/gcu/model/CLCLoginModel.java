package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CLCLoginModel 
{
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String username; 

	@NotNull(message="Password is required field")
	@Size(min=1, max=32, message="Password must be between 1-32 characters")
	private String password;
	
	
	
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



	public CLCLoginModel() {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
