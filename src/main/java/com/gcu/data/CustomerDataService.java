package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.SignupModel;

public class CustomerDataService implements DataAccessInterface<SignupModel>
{

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-default constructor for constructor injection
	 */
	@Autowired
	public CustomerDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<SignupModel> finalAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignupModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(SignupModel t) 
	{
		String str = "INSERT INTO USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, USERNAME, PASSWORD) VALUES(?,?,?,?,?,?)";
		try
		{
			int rows = jdbcTemplateObject.update(str, 0, t.getFirstName(), t.getLastName(), t.getEmail(), t.getUsername(), t.getPassword());
			
			return rows == 1 ? true :false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean update(SignupModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}