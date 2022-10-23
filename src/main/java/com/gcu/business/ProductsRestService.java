package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

@RestController
@RequestMapping("/service")
public class ProductsRestService 
{
	@Autowired
	ProductsBusinessServiceInterface service;
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductssAsJson()
	{
		return service.getProducts();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductList getProductsAsXml()
	{
		ProductList list = new ProductList();
		list.setProducts(service.getProducts());
		return list;
	}
}