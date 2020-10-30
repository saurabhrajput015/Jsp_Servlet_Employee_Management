package com.demo.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//define the fields
    String username="root";
    String password="";
    String jdbcURL="jdbc:mysql://localhost:3306/saurabh";
    String driver="com.mysql.jdbc.Driver";
    
    try {
    	//Get the PrintWriter object
        PrintWriter writer=response.getWriter();
        writer.println("Connecting to database" +jdbcURL);
        //Load the Driver
        Class.forName(driver);
        //Get the Connection
        Connection connection=DriverManager.getConnection(jdbcURL,username,password);
        writer.println("Connection Successfully");
        //close the connection
        connection.close();
    	
    }catch(Exception e) {
    	e.printStackTrace();
    }
    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
