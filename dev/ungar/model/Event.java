package dev.ungar.model;

public class Event {
	
	int eventId;
	String eventType;
	int eventCoverage;
	
	public Event() {
		super();
	}

	public Event(int eventId, String eventType, int eventCoverage) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.eventCoverage = eventCoverage;
	}
	
	public Event(String eventType, int eventCoverage) {
		super();
		this.eventType = eventType;
		this.eventCoverage = eventCoverage;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getEventCoverage() {
		return eventCoverage;
	}

	public void setEventCoverage(int eventCoverage) {
		this.eventCoverage = eventCoverage;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventType=" + eventType + ", eventCoverage=" + eventCoverage + "]";
	}


	
	
	

}
