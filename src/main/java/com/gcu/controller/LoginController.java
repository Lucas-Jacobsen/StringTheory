package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;
import com.gcu.model.SignupModel;

//controller for the first welcome page
@Controller
@RequestMapping("/login")
public class LoginController
{
	
	@Autowired
	private ProductsBusinessService service;
	
	
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
		return "signup";
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
		
		
	
		
		
		//Create products
		List<ProductModel> products =service.getProducts();
		//products.add(new ProductModel(0,"Electric Guitar", "Electtic Guitar Description", 249.99f));
		//products.add(new ProductModel(0,"Acoustic Guitar", "Acoustic Guitar Description", 199.99f));
		//products.add(new ProductModel(0,"Bass Guitar", "Bass Guitar Description", 174.99f));
		//products.add(new ProductModel(0,"Amplifier", "Amplifier  Description", 99.99f));

		
		//Display orders view
		model.addAttribute("title", "Our Products");
		model.addAttribute("products", products);
		
		//returns orders.html on enter
		return "orders";
	}	
	
 @GetMapping("/createProduct")	
 public String doCreate(Model model)
 {
	 model.addAttribute("Title", "Create Product");
	 
	 return "createProduct";
 }
 
@GetMapping("/orders")
public String doProduct(Model model)
{
	return "orders";
}
		
	
	
	

	
	
	
	
}
