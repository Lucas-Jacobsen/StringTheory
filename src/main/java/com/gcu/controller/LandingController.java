package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/login")
public class LandingController 
{
	
	@Autowired 
	private ProductsBusinessServiceInterface service;
	
	
	
	/**
	 * To Products Page
	 * 
	 * @param productList ProductList
	 * @param model       Model
	 * @param Id          Integer
	 * @return string of exception or orders
	 */
	@GetMapping("/doProducts")
	public String doProducts(ProductList productList, Model model,
			@RequestParam(value = "id", required = false) Integer Id) {
		try {
			// Create products
			List<ProductModel> products = service.getProducts();

			// Display orders view
			model.addAttribute("title", "Our Products");
			model.addAttribute("products", products);
			model.addAttribute("EditID", Id);
			return "orders";
		} catch (Exception e) {
			return "exception";
		}
	}
	
	/**
	 * To create a new product
	 * 
	 * @param productModel  ProductModel
	 * @param bindingResult BindingResult
	 * @param model         Model
	 * @return createProduct or exception
	 */
	@GetMapping("/doCreate")
	public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		try {

			// Check for validation order
			if (bindingResult.hasErrors()) {
				model.addAttribute("title", "Login Form");
				// returns to welcome.html on error
				return "createProduct";
			}
			model.addAttribute("createProduct", new ProductModel());

			return "createProduct";
		} catch (Exception e) {
			return "exception";
		}
	}
}
