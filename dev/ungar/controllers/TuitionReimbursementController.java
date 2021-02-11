package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.TuitionReimbursement;
import dev.ungar.services.TuitionReimbursementService;
import dev.ungar.services.TuitionReimbursementServiceImpl;

public class TuitionReimbursementController {
	
	public static TuitionReimbursementService s = new TuitionReimbursementServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getTuitionReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		TuitionReimbursement t = s.getTuitionReimbursement(id);
		response.getWriter().append((t != null) ? gson.toJson(t) : "{}");
		
	}

}
