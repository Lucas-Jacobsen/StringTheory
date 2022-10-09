package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;
import com.gcu.model.SignupModel;

//controller for the first welcome page
@Controller
@RequestMapping("/login")
public class LoginController
{
	//second backslash comes after the first login so we can have a welcome page
	@GetMapping("/")
	public String display(Model model)
	{
		//Display Login form view
		model.addAttribute("Title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
			//returns welcome.html
		return "welcome";
	}
	//signup page for if you do not have an account
	@PostMapping("/doSignup")
	public String doSignin(Model model)
	{
		model.addAttribute("Title", "Signup Form");
		model.addAttribute("SignupModel", new SignupModel());
		

		//return signin.html
		return "signin";
	}
	
	//login page when you enter the login button
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		
		//Check for validation order
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			//returns to welcome.html on error
			return "welcome";
		}
		
		/*/Create products
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(2L, "000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel(3L, "000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel(4L, "000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel(5L, "000005", "Product 5", 5.00f, 5));
		*/
		
	
		
		
		//Create products
		List<ProductModel> products = new ArrayList<ProductModel>();
		products.add(new ProductModel(0,"Electric Guitar", "Electtic Guitar Description", 249.99f));
		products.add(new ProductModel(0,"Acoustic Guitar", "Acoustic Guitar Description", 199.99f));
		products.add(new ProductModel(0,"Bass Guitar", "Bass Guitar Description", 174.99f));
		products.add(new ProductModel(0,"Amplifier", "Amplifier  Description", 99.99f));

		
		//Display orders view
		model.addAttribute("title", "Our Products");
		model.addAttribute("products", products);
		
		//returns orders.html on enter
		return "orders";
	}	
	
		
	
	
	
	
	

	
	
	
	
}
