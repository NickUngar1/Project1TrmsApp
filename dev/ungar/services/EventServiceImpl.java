package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.EventDAO;
import dev.ungar.daos.EventDAOImpl;
import dev.ungar.model.Event;

public class EventServiceImpl implements EventService {
	
	EventDAO ed = new EventDAOImpl();

	@Override
	public Event getEvent(int id) {
		return ed.getEvent(id);
	}

	@Override
	public boolean addEvent(Event a) {
		return ed.addEvent(a);
	}

	@Override
	public List<Event> getAllEvents() {
		return ed.getAllEvents();
	}

	@Override
	public boolean updateEvent(Event change) {
		return ed.updateEvent(change);
	}

	@Override
	public boolean deleteEvent(int id) {
		return ed.deleteEvent(id);
	}

}
