package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

public interface ProductsBusinessServiceInterface 
{
	public void test();
	
	public default List<ProductModel> getProducts()
	{
		//Create products
				List<ProductModel> Products = new ArrayList<ProductModel>();
				Products.add(new ProductModel(1, "000001", "Product 1", 1.00f));
				Products.add(new ProductModel(2, "000002", "Product 2", 2.00f));
				Products.add(new ProductModel(3, "000003", "Product 3", 3.00f));
				Products.add(new ProductModel(4, "000004", "Product 4", 4.00f));
				Products.add(new ProductModel(5, "000005", "Product 5", 5.00f));
				
				return Products;
	}
	
	public void init();
	
	public void destroy();

	

	
}
