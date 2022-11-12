package com.gcu.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
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
	@Override
	public boolean getNewProduct(ProductModel product)
	{
		ProductModel pm = product;
		return service.create(pm);
	}
	 
	@Override
	public ProductModel getProductByID(int id)
	{
		return service.findById(id);
	}
	
	@Override
	public boolean updateProduct(ProductModel t)
	{
		return service.update(t);
	}
	
	public boolean deleteProducts(int id)
	{
		return service.delete(id);
	}
	
}


