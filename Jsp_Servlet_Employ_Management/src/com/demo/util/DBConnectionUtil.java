package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

	//Define the database properties
	
	private static final String URL="jdbc:mysql://localhost:3306/saurabh";
	
	private static final String DRIVER="com.mysql.jdbc.Driver";
	
	private static final String USERNAME="root";
	
	private static final String PASSWORD="";
	
	private static Connection connection=null;
	
	//Define the static method
	
	public static Connection openConnection() {
		
		
		//Check the connection
		if(connection != null) {
			return connection;
		}else {
			
			try {

				//Load the driver
				Class.forName(DRIVER);
				
				//Get the connection
				connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return connection;
		
		
	}
}
