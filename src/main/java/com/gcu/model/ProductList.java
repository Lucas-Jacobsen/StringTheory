package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductList 
{
	private List<ProductModel> orders = new ArrayList<ProductModel>();
	
	@XmlElement(name="product")
	public List<ProductModel> getProducts()
	{
		return this.orders;
	}


	public void setProducts(List<ProductModel> products) 
	{
		this.orders = orders;

	}
			
}
