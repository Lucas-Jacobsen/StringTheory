package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService 
{
	public boolean authenticateLogin(String username, String password)
	{
		System.out.printf("\nUsername %s Authenticated\n", username);
		System.out.printf("\nPassword %s Authenticated\n", password);
		return true;
	}
	public boolean authenticateSignup(String firstName, String lastName, String email, String username, String password)
	{
		System.out.printf("\nUsername %s Authenticated", firstName);
		System.out.printf("\nUsername %s Authenticated", lastName);
		System.out.printf("\nUsername %s Authenticated", email);
		System.out.printf("\nUsername %s Authenticated", username);
		System.out.printf("\nUsername %s Authenticated", password);

		return true;
	}
	
}