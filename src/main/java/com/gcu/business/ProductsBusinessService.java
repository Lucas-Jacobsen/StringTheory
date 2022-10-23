package com.gcu.business;
import java.io.Serializable;

public class ProductsBusinessService implements ProductsBusinessServiceInterface
{

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
}



