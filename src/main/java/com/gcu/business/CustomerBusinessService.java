package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.SignupModel;

@Service
public class CustomerBusinessService implements CustomerBusinessServiceInterface
{
	
	
	DataAccessInterface<SignupModel> customerService;
	
	@Override
	public boolean getNewUser(SignupModel signup)
	{
		
		SignupModel sm = signup;
		
		return customerService.create(sm);
	}

	
	
}