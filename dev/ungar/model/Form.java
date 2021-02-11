package dev.ungar.model;

public class Form {
	
	int formId;
	int empId;
	String eventLocation;
	String eventDescription;
	double eventCost;
	int eventId;
	int gradeId;
	
	public Form() {
		super();
	}

	public Form(int formId, int empId, String eventLocation, String eventDescription,
			double eventCost, int eventId, int gradeId) {
		super();
		this.formId = formId;
		this.empId = empId;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
		this.eventCost = eventCost;
		this.eventId = eventId;
		this.gradeId = gradeId;
	}
	
	public Form(int empId, String eventLocation, String eventDescription,
			double eventCost, int eventId, int gradeId) {
		super();
		this.empId = empId;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
		this.eventCost = eventCost;
		this.eventId = eventId;
		this.gradeId = gradeId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public double getEventCost() {
		return eventCost;
	}

	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	public String toString() {
		return "Form [formId= auto generated sequence" + ", empId=" + empId + ", eventLocation=" + eventLocation + ", eventDescription=" + eventDescription + ", eventCost="
				+ eventCost + ", eventId=" + eventId + ", gradeId=" + "8" + "]";
	}
	
	

}
