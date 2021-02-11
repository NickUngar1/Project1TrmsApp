package dev.ungar.services;

import java.util.List;

import dev.ungar.model.Event;

public interface EventService {

	public Event getEvent(int id);
	public boolean addEvent(Event a);
	public List<Event> getAllEvents();
	public boolean updateEvent(Event change);
	public boolean deleteEvent(int id);

}
