package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.EmployeeDAO;
import com.demo.dao.EmployeeDAOImpl;
import com.demo.entity.Emplo;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher=null;
	//Create a ref variable for employee DAO
	EmployeeDAO employeeDAO =null;
	
	//Create constructor and initaize employee DAO
	public EmployeeController() {
	employeeDAO =new EmployeeDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action==null) {
			action="LIST";
		}
		switch(action) {
		    case "LIST":
		    listEmployees(request,response);
		    break;
		    
		    case "EDIT":
		    	getSingleEmployee(request,response);
		    	break;
		    	
		    case "DELETE":
		    	deleteEmployee(request,response);
		    	break;
		    	 	
		    	
		     default:
		    	listEmployees(request,response);
		    	break;
		}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id=request.getParameter("id");
	    String name=request.getParameter("firstname");
		String dob=request.getParameter("dob");
		String department=request.getParameter("department");
		
		Emplo e=new Emplo();
		
		e.setName(name);
		e.setDepartment(department);
		e.setDob(dob);
		if(id.isEmpty() || id==null) {
			//save the operation
			if(employeeDAO.save(e)) {
	              request.setAttribute("message", "saved Successfully...");
				
			}
		}else {
			//update operation
			e.setId(Integer.parseInt(id));
			if(employeeDAO.update(e)) {
	              request.setAttribute("message", "update Successfully...");
				
			}
		}
		
		
		
		listEmployees(request, response);
	}
	public void listEmployees(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //Call dao method to get list of employees
		List<Emplo> theList = employeeDAO.get();
		//Add the employees to  request dispatcher
		request.setAttribute("list", theList);
		//Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		//forward the req and res objects
		dispatcher.forward(request, response);
	}
	
	public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Emplo employee=employeeDAO.get(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		//Get the request dispatcher
				dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");
				//forward the req and res objects
				dispatcher.forward(request, response);
		
	}
    
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String id=request.getParameter("id");
		if(employeeDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Record has been deleted");
		}
		listEmployees(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
