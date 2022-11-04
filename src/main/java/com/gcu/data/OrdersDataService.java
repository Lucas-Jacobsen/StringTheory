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
		String sql = "SELECT * FROM ORDERS";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try
		{
			//EXecute SQL Query and loop over results set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				products.add(new ProductModel(srs.getInt("ID"),
											srs.getString("PRODUCT_NAME"),
											srs.getString("PRODUCT_DESCRIPTION"),
											srs.getFloat("PRICE")));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(ProductModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProductModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProductModel t) {
		// TODO Auto-generated method stub
		return false;
	}
}
