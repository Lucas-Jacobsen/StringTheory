package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SignupModel 
{
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String firstName;
	
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String lastName;
	
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String email;
	
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String username; 

	@NotNull(message="Password is required field")
	@Size(min=1, max=32, message="Password must be between 1-32 characters")
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
	
	public SignupModel() {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.username = username;
			this.password = password;
			
		}
	
	
	
	
}
