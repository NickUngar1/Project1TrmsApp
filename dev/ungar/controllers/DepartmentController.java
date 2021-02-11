package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Department;
import dev.ungar.services.DepartmentService;
import dev.ungar.services.DepartmentServiceImpl;

public class DepartmentController {
	public static DepartmentService s = new DepartmentServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Department dept = s.getDept(id);
		response.getWriter().append((dept != null) ? gson.toJson(dept) : "{}");
		
	}

}
