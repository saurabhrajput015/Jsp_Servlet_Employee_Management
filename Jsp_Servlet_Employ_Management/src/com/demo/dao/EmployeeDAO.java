package com.demo.dao;

import java.util.List;

import com.demo.entity.Emplo;

public interface EmployeeDAO {

	List<Emplo> get();
	
	  boolean save(Emplo e);
	
	  Emplo get(int id);
	  
	  boolean update(Emplo e);
	  
	  boolean delete(int id);
}
