  package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;
/**
 * Spring Bean implementation class OrderDataService
 */
@Service
public class OrdersDataService implements DataAccessInterface<ProductModel>
{
	@SuppressWarnings("unused")
	@Autowired 
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-default constructor for constructor injection
	 */
	@Autowired
	public OrdersDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ProductModel> finalAll() {
		String sql = "SELECT * FROM PRODUCTS";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try
		{
			//EXecute SQL Query and loop over results set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				products.add(new ProductModel(srs.getInt("PRODUCT_ID"),
											srs.getString("PRODUCT_CATEGORY"),
											srs.getString("PRODUCT_NAME"),
											srs.getString("PRODUCT_DESCRIPTION"),
											srs.getFloat("PRODUCT_PRICE")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ProductModel findById(int id) {
		
		
		String cat = "";
		String name = "";
		String des ="";
		float price =0;
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID = '"+id+ "'";

		List<ProductModel> products = new ArrayList<ProductModel>();
		ProductModel pm = new ProductModel();
		ProductModel pm2 = new ProductModel();

		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
		while(srs.next())
		{
			
			
			/*
			 * pm = new ProductModel(2, srs.getString("PRODUCT_CATEGORY"),
			 * srs.getString("PRODUCT_NAME"), srs.getString("PRODUCT_DESCRIPTION"),
			 * srs.getFloat( "PRODUCT_PRICE"));
			 */
			 
			  cat = srs.getString("PRODUCT_CATEGORY"); System.out.println(srs.getString("PRODUCT_CATEGORY"));
			  name =srs.getString("PRODUCT_NAME"); System.out.println(srs.getString("PRODUCT_NAME"));
			  des = srs.getString("PRODUCT_DESCRIPTION");System.out.println(srs.getString("PRODUCT_DESCRIPTION"));
			  price = srs.getFloat("PRODUCT_PRICE");System.out.println(srs.getFloat("PRODUCT_PRICE"));
			  pm = new ProductModel(id, cat, name, des, price);
			  //pm2 = new ProductModel(2, pm.getProductCategory(),pm.getProductName(),
			  //pm.getProductDescription(), pm.getProductPrice());
			  //System.out.println(pm.getProductCategory());
			 		
			//System.out.println(pm.getProductCategory().toString()+ pm.getProductDescription().toString()+pm.getProductName().toString());
			//pm = new ProductModel (id, "lukecat","lukename","lukedes", 10);
			
			 pm = new ProductModel(id, cat, name, des, price);			
			
			System.out.println(("-----------------------------"));
			
		}
		return pm;
	}

	@Override
	public boolean create(ProductModel product) 
	{
		String sql = "INSERT INTO PRODUCTS(PRODUCT_ID, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE) VALUES(?,?,?,?,?)";

		//execute sql
		int rows = jdbcTemplateObject.update(sql, 0,  product.getProductCategory(), product.getProductName(), product.getProductDescription(), product.getProductPrice());

		return rows ==1 ? true : false;
	}

	@Override
	public boolean update(ProductModel t) {
		//THIS METHOD ACTUALLY WORKED----------------------------------
		//--------------------------------------------------------------
		int productUpdate = t.productID;
		//Hard coded for testing purposes
		//productUpdate = 1;
		String sql = "UPDATE PRODUCTS SET PRODUCT_NAME =?, PRODUCT_CATEGORY = ?, PRODUCT_DESCRIPTION = ?, PRODUCT_PRICE = ? WHERE PRODUCT_ID = '"+productUpdate+ "'";
		
		
		System.out.println(t.getProductName());
		System.out.println(t.getProductCategory());
		System.out.println(t.getProductName());
		System.out.println(t.getProductDescription());
		System.out.println(t.getProductPrice());
		int rows = jdbcTemplateObject.update(sql, t.getProductName(), t.getProductCategory(), t.getProductDescription(), t.getProductPrice());
		return rows == 1 ? true : false;
	}

	@Override
	public boolean delete(int id) {

		String sql = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = "+ id +"";
		
		int rows = jdbcTemplateObject.update(sql);
		
		return rows == 1 ? true : false;
	}
}
