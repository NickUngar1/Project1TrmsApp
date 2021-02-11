package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Approval;
import dev.ungar.services.ApprovalService;
import dev.ungar.services.ApprovalServiceImpl;

public class ApprovalController {
	
	public static ApprovalService s = new ApprovalServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getApproval(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Approval app = s.getApproval(id);
		response.getWriter().append((app != null) ? gson.toJson(app) : "{}");
		
	}

}
