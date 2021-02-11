package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.Event;

//static table only needs to be referenced
public interface EventDAO {
	
	public Event getEvent(int id);
	public boolean addEvent(Event ev);
	public List<Event> getAllEvents();
	public boolean updateEvent(Event change);
	public boolean deleteEvent(int id);

}
