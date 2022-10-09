package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// creating the sign up model
public class SignupModel 
{
	//errors on first name handling
	@NotNull(message="First Name is required field")
	@Size(min=1, max=32, message="first name must be between 1-32 characters")
	private String firstName;
	
	
	//errors on last name handling
	@NotNull(message="Last name is required field")
	@Size(min=1, max=32, message="last name must be between 1-32 characters")
	private String lastName;
	
	
	//errors on email handling
	@NotNull(message="email is required field")
	@Size(min=1, max=32, message="email must be between 1-32 characters")
	private String email;
	
	
	//username errors
	@NotNull(message="Username is required field")
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String username; 

	//password handling
	@NotNull(message="Password is required field")
	@Size(min=1, max=32, message="Password must be between 1-32 characters")
	private String password;

	

	//getters and setters for the sign up
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
