package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.LoginModel;

@Controller
public class WelcomeController 
{
	/**
	 * Get Mapping for project
	 * 
	 * @param model model
	 * @return string of exception or welcome
	 */
	@PostMapping("/")
	public String display(Model model) 
	{
		try 
		{
			// Display Login form view
			model.addAttribute("Title", "Login Form");
			model.addAttribute("loginModel", new LoginModel());
			// returns welcome.html
			return "welcome";
		} 
		catch (Exception e) 
		{
			return "exception";
		}
	}
}