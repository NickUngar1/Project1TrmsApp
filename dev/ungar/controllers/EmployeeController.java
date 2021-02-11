package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Employee;
import dev.ungar.services.EmployeeService;
import dev.ungar.services.EmployeeServiceImpl;

public class EmployeeController {
	
	//read any necessary info from request
	//call the appropriate service(s)
	//prepare our data to be added to the response
	//add said data into the response body
	
	//processing requests and generating responses
	
	public static EmployeeService s = new EmployeeServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return; 
		}
		
		
		Employee emp = s.getEmployee(id);
		response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
		
	}
	
	public static void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		
		Employee emp = gson.fromJson(request.getReader(), Employee.class);
		System.out.println("emp created");
			
		Employee loggedInEmployee = s.login(emp.getEmpEmail(), emp.getEmpPassword());
		System.out.println("emp logged in");
		
		if(loggedInEmployee == null) {
			response.getWriter().append("The email and/or password you have entered is incorrect");
		}
		else {
			Cookie c = new Cookie("empEmail", loggedInEmployee.getEmpEmail());
			System.out.println("cookie object created");
			System.out.println(c);
			c.setSecure(true);
			c.setMaxAge(60 * 60);
			response.addCookie(c);
			response.getWriter().append(gson.toJson(loggedInEmployee));
			
//			System.out.println("cookie has been saved with name " + c.getName() + " and value " + c.getValue());
//			System.out.println("Successful login \n " + loggedInEmployee);
		}
		
	}
	
	public static void getLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		Cookie c = null;
		String email;
		
		for(int i = 0; i < cookies.length; i++) {
			c=cookies[i];
			if(c.getName().equals("empEmail")) {
				email = c.getValue();
				Employee emp = s.getEmployee(email);
				response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
				break;
			}
		}
	}

}
