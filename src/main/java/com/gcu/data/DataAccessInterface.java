package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



public interface DataAccessInterface <T>
{
	
	public List<T> finalAll();
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(int id);
	
}