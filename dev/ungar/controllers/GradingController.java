package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Grading;
import dev.ungar.services.GradingService;
import dev.ungar.services.GradingServiceImpl;

public class GradingController {
	
	public static GradingService s = new GradingServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getGrading(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Grading g = s.getGrading(id);
		response.getWriter().append((g != null) ? gson.toJson(g) : "{}");
		
	}

}
