package dev.ungar.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ungar.controllers.AppController;
import dev.ungar.controllers.ApprovalController;
import dev.ungar.controllers.DepartmentController;
import dev.ungar.controllers.EmployeeController;
import dev.ungar.controllers.EventController;
import dev.ungar.controllers.FormController;
import dev.ungar.controllers.GradingController;
import dev.ungar.controllers.TuitionReimbursementController;

public class RequestHelper {
	
	/**
	 * This method will delegate other methods on the controller layer
	 * of our application to process the request.
	 * @param req: HTTP Request
	 * @param res: HTTP Response
	 * @throws IOException 
	 */
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch(uri) {
		case "/TrmsApp/getEmployee.do": {
			EmployeeController.getEmployee(request, response);
			break;
		}
		case "/TrmsApp/login.do": {
			EmployeeController.employeeLogin(request, response);
			break;
		}
		case "/TrmsApp/getEmployeeByEmail.do": {
			EmployeeController.getLoggedIn(request, response);
			break;
		}
		case "/TrmsApp/addForm.do": {
			FormController.addForm(request, response);
			break;
		}
		case "/TrmsApp/getTR.do": {
			TuitionReimbursementController.getTuitionReimbursement(request, response);
			break;
		}
		case "/TrmsApp/getApp.do": {
			ApprovalController.getApproval(request, response);
			break;
		}
		case "/TrmsApp/getForm.do": {
			FormController.getForm(request, response);
			break;
		}
//		case "/TrmsApp/supApp.do": {
//			AppController.getSupForm(request, response);
//			break;
//		}
//		case "/TrmsApp/supUp.do": {
//			System.out.println("supup test");
//			FormController.supUp(request, response);
//			break;
//		}
		case "/TrmsApp/ceoGet.do": {
			FormController.ceoGet(request, response);
			break;
		}
		case "/TrmsApp/ceoUp.do": {
			FormController.ceoUp(request, response);
			break;
		}
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, is teapot");
			break;
		}
		}
	}

}
