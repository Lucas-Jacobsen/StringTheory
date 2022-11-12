	package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.CustomerBusinessService;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.SecurityBusinessService;
import com.gcu.data.CustomerDataService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;
import com.gcu.model.SignupModel;

//controller for the first welcome page
@Controller
@RequestMapping("/login")
public class LoginController
{
	@SuppressWarnings("unused")
	@Autowired
	private ProductsBusinessService service;
	@Autowired
	SecurityBusinessService security;
	@SuppressWarnings("unused")
	@Autowired
	private CustomerBusinessService customerService;
	
	
	//second backslash comes after the first login so we can have a welcome page
	@GetMapping("/")
	public String display(Model model)
	{
		try {
		//Display Login form view
		model.addAttribute("Title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
			//returns welcome.html
		return "welcome";}
		 catch(Exception e)
		 {
				return "exception";
		 }
	}
	//sign up page for if you do not have an account
	@PostMapping("/doSignup")
	public String doSignin(Model model)
	{try {
		
		model.addAttribute("createCustomer", new SignupModel());
		

		return "signup";}
	 catch(Exception e)
	 {
			return "exception";
	 }
	}
	
	@PostMapping("/newCutomerResults")
	public String doSignupResults(SignupModel signupModel, Model model)
	{
		try
		{
			

			customerService.getNewUser(signupModel);
			
			model.addAttribute("newCustomer", signupModel);
			return "signupResults";
		}
		catch(Exception e){
			return "exception";
		}
		

	}
	//login page when you enter the login button - take you to landing page
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, SignupModel signup)
	{
		try {
		
		//Check for validation order
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			//returns to welcome.html on error
			return "welcome";
		}
		
		security.authenticateLogin(loginModel.getUsername(), loginModel.getPassword());
		
		//returns orders.html on enter
		//Change back to landing when done testing exception
		return "landing";}
		 catch(Exception e)
		 {
				return "exception";
		 }
	}	
	@PostMapping("/error")
	public String doLanding(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, SignupModel signup)
	{
		try {
		
		//Check for validation order
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			//returns to welcome.html on error
			return "welcome";
		}
		
		security.authenticateLogin(loginModel.getUsername(), loginModel.getPassword());
		
		//returns orders.html on enter
		//Change back to landing when done testing exception
		return "landing";}
		 catch(Exception e)
		 {
				return "exception";
		 }
	}	
	
	//To products page 
	@PostMapping("/doProducts")
	public String doProducts(ProductList productList, Model model, @RequestParam(value="id", required =false)Integer Id)
	{
		try {
				//Create products
				List<ProductModel> products =service.getProducts();
				
				//Display orders view
				model.addAttribute("title", "Our Products");
				model.addAttribute("products", products);
				model.addAttribute("EditID", Id);
		return "orders";}
		 catch(Exception e)
		 {
				return "exception";
		 }
	}
//Take user to createProduct page
 @PostMapping("/doCreate")	
 public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
 {
	 try {
	 

	//Check for validation order
			if(bindingResult.hasErrors())
			{
				model.addAttribute("title", "Login Form");
				//returns to welcome.html on error
				return "createProduct";
			}
	model.addAttribute("createProduct", new ProductModel());
	 
	 return "createProduct";}
	 catch(Exception e)
	 {
			return "exception";
	 }
 }
 
@PostMapping("/doCreateResults")
public String doCreateResults(ProductModel productModel, Model model)
{
	try 
	{
	
	service.getNewProduct(productModel);
	

	ProductModel newProduct = service.getProducts().get(service.getProducts().size() - 1);
	
	
	model.addAttribute("newProduct", newProduct);

	
	
	return "createProductResults";
}
catch(Exception e){
	return "exception";
}}
	
	
	@PostMapping("/doUpdate")	
	 public String doUpdate( ProductModel productModel, BindingResult bindingResult, Model model, Integer FLAG)
	 {
		// try {
		 
		
		model.addAttribute("EditID", FLAG);
		model.addAttribute("updateProduct", new ProductModel());
			
		//Check for validation order
				if(bindingResult.hasErrors())
				{
					model.addAttribute("title", "Login Form");
					//returns to welcome.html on error
					return "updateProduct";
				}
				
		 
		 return "updateproduct";
		 //}
		 //catch(Exception e)
		 //{
				//return "exception";
		 //}
}
	@PostMapping("/doUpdateResults")
	public String doUpdateResults(ProductModel productModel, BindingResult bindingResult, Model model)
	{
		model.addAttribute("updatedProduct", productModel);
		
		//ProductModel productToUpdate = service.getProductByID(2);
		
		service.updateProduct(productModel);
		
		return "updateProductResults";
		
	}
	
	@PostMapping("/doDelete")
	public String doDelete(ProductModel productModel, BindingResult bindingResult, Model model)
	{
		
		model.addAttribute("deleteProduct", productModel);

		return "delete";
		
	}
	
	@PostMapping("/doDeleteResults")
	public String doDeleteResults(ProductModel productModel, BindingResult bindingResult, Model model)
	{
		model.addAttribute("deleteResults", productModel.productID);
		int deleteID = productModel.productID;
		service.deleteProducts(deleteID);
		return "deleteResults";
	}
	
	
	
	

	
	
	
	
}