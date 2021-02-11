package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Approval;
import dev.ungar.model.Form;
import dev.ungar.model.TuitionReimbursement;
import dev.ungar.services.AppService;
import dev.ungar.services.AppServiceImpl;
import dev.ungar.services.ApprovalService;
import dev.ungar.services.ApprovalServiceImpl;
import dev.ungar.services.FormService;
import dev.ungar.services.FormServiceImpl;
import dev.ungar.services.TuitionReimbursementService;
import dev.ungar.services.TuitionReimbursementServiceImpl;

public class FormController {
	public static FormService fs = new FormServiceImpl();
	public static TuitionReimbursementService trs = new TuitionReimbursementServiceImpl();
	public static ApprovalService as = new ApprovalServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Form f = fs.getFormByEmpId(id);
		System.out.println(f.getEmpId());
		response.getWriter().append((f != null) ? gson.toJson(f) : "{}");
		
	}
	
	public static void addForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Form f = gson.fromJson(request.getReader(), Form.class);
		
		System.out.println("Form successfully created");
		System.out.println(f);
		
		boolean success = fs.addForm(f);
		
		response.getWriter().append((success) ? gson.toJson(f) : "{}");
		
		//update tuition reimbursement tracker
		trs.updatePending(f.getEventCost(), f.getEmpId());
		
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
		
		fs.supUp(id);
		//response.getWriter().append((f != null) ? gson.toJson(f) : "{}");
	}

	public static void ceoGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		System.out.println("ceoGet input " + input);
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		System.out.println(id + " is the id pushed to ceoGet");
		Form f = fs.ceoGet(id);
		System.out.println("form is" + f);
		response.getWriter().append((f != null) ? gson.toJson(f) : "{}");
	}
	public static void ceoUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		fs.updateApproved(200, id);
		fs.ceoUp(id);
		
	}
	



}
