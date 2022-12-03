package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.SignupModel;

public interface CustomerBusinessServiceInterface {
	public default boolean getNewUser(SignupModel t) {
		return false;
	}

}
