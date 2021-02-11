package dev.ungar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.ungar.model.Event;
import dev.ungar.services.EventService;
import dev.ungar.services.EventServiceImpl;

public class EventController {
	
	public static EventService s = new EventServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Event ev = s.getEvent(id);
		response.getWriter().append((ev != null) ? gson.toJson(ev) : "{}");
		
	}

}
