package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Form;
import dev.ungar.services.AppService;
import dev.ungar.services.AppServiceImpl;

public class AppController {
	
	public static AppService s = new AppServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getSupForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Form f = s.getFormsAsSup(id);
		response.getWriter().append((f != null) ? gson.toJson(f) : "{}");
		
	}
	
	public static void supUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		s.supUp(id);
		//response.getWriter().append((f != null) ? gson.toJson(f) : "{}");
	}

}
