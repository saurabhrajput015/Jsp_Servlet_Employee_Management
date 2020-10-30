package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.entity.Emplo;
import com.demo.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection= null;
	Statement statement= null;
	ResultSet resultSet= null;
	PreparedStatement preparedStatement= null;
	
	
	
	@Override
	public List<Emplo> get() {
		
		//Create a reference variable
		List<Emplo> list=null;
		Emplo employee=null;
		
		try
		{
			list =new ArrayList<Emplo>();
		
		//Create a sql query
		String sql="SELECT * FROM tbl_employee";
		
		//Get the database connection
		connection =DBConnectionUtil.openConnection();
		//Create a statement 
		statement =connection.createStatement();
		//Execute the sql query
		resultSet =statement.executeQuery(sql);
		//Process the resultset
		while(resultSet.next()) {
			employee=new Emplo();
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setDepartment(resultSet.getString("department"));
			employee.setDob(resultSet.getString("dob"));
		
			//Add employee to list
			list.add(employee);
		}
		
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		//return the list
		return list;
	}

	public boolean save(Emplo e) {
		
		
		boolean flag = false;
		try
		{
			String sql="INSERT INTO tbl_employee(name,dob,department)VALUES('"+e.getName()+"','"+e.getDob()+"','"+e.getDepartment()+"')";
			connection =DBConnectionUtil.openConnection();
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}catch(SQLException ex )
		{
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public Emplo get(int id) {
		Emplo employee=null;
		try
		{
			employee =new Emplo();
			String sql="SELECT * FROM tbl_employee WHERE id="+id;
			connection =DBConnectionUtil.openConnection();
			statement  =connection.createStatement();
			resultSet  =statement.executeQuery(sql);
			while(resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Employee name:"+employee.getName()+"Employee dob:"+employee.getDob()+"Employee department:"+employee.getDepartment());
		return employee;
	}

	@Override
	public boolean update(Emplo e) {
		
		
		boolean flag=false;
		try
		{
			
			String sql="UPDATE tbl_employee SET name='"+e.getName()+"',dob='"+e.getDob()+"',department='"+e.getDepartment()+"' where id="+e.getId();
		    connection =DBConnectionUtil.openConnection();
		    preparedStatement =connection.prepareStatement(sql);
		    preparedStatement.executeUpdate();
		    flag=true;
		    
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
    public boolean delete(int id) {
		boolean flag=false;
		try
		{
			String sql="DELETE FROM tbl_employee WHERE id=" +id;
			 connection =DBConnectionUtil.openConnection();
			 preparedStatement =connection.prepareStatement(sql);
			 preparedStatement.executeUpdate();
			 flag=true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	

}
