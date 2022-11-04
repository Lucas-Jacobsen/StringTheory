package com.gcu.business;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

public class ProductsBusinessService implements ProductsBusinessServiceInterface
{

	@Autowired
	DataAccessInterface<ProductModel> service;
	
	public void test() 
	{	
		System.out.println("Hello from the ProductsBusinessService");
		
	}
	public void init()
	{
		System.out.println("Hello from the ProductsBusinessService init method");
	}
	
	public void destroy()
	{
		System.out.println("Hello from the ProductsBusinessService destroy method");
	}
	
	@Override
	public List<ProductModel> getProducts()
	{ 	
		return service.finalAll();
	}
}



