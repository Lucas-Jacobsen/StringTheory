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
import com.gcu.model.ProductList;
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
		model.addAttribute("Title", "Signup Form");
		model.addAttribute("SignupModel", new SignupModel());
		

		return "signup";}
	 catch(Exception e)
	 {
			return "exception";
	 }
	}
	
	//login page when you enter the login button - take you to landing page
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		try {
		
		//Check for validation order
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			//returns to welcome.html on error
			return "welcome";
		}
		
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
	public String doProducts(ProductList productList, Model model )
	{
		try {
				//Create products
				List<ProductModel> products =service.getProducts();
				
				//Display orders view
				model.addAttribute("title", "Our Products");
				model.addAttribute("products", products);
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
	 
	model.addAttribute("createProduct", new ProductModel());
	 
	 return "createProduct";}
	 catch(Exception e)
	 {
			return "exception";
	 }
 }
 
@PostMapping("/doCreateResults")
public String doCreateResults(ProductModel productModel, Model model)
{try {
	//Adds new product to new list
	List<ProductModel> newProduct = new ArrayList<ProductModel>();
	newProduct.add(new ProductModel(5, productModel.getProductName(), productModel.getProductDescription(), productModel.getProductPrice()));
	//add new product to product list 
	ProductList pl = new ProductList();
	pl.products.add(new ProductModel(5, productModel.getProductName(), productModel.getProductDescription(), productModel.getProductPrice()));
	//send new list to createProductResults page
	model.addAttribute("newProduct", newProduct);
	
	return "createProductResults";
}
catch(Exception e){
	return "exception";
}

}
	
	
	
	

	
	
	
	
}
