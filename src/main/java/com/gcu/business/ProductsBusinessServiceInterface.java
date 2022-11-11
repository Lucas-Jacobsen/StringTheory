package com.gcu.business;

import java.util.ArrayList;
import java.util.List;


import com.gcu.model.ProductModel;

public interface ProductsBusinessServiceInterface 
{
	public void test();
	
	public default List<ProductModel> getProducts()
	{
		//Create products
				List<ProductModel> Products = new ArrayList<ProductModel>();
				/**Products.add(new ProductModel(1, "Electric Guitars", "Amplify your playing with these guitars", 249.99f));
				Products.add(new ProductModel(2, "Acoustic Guitars", "Look no further for the best acoustics on the market.", 199.99f));
				Products.add(new ProductModel(3, "Bass Guitars", "Play those low notes in style...", 174.99f));
				Products.add(new ProductModel(4, "Amplifiers", "Get Loud. As loud as possible!", 99.99f));
				**/
				return Products;
	}
	
	public default boolean getNewProduct(ProductModel product)
	{
		return false;
	}
	public void init();
	
	public void destroy();


	
 
	
}