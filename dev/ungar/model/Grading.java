package dev.ungar.model;

public class Grading {
	
	int gradeId;
	String gradeType;
	int gradePassingStatus;
	
	public Grading() {
		super();
	}

	public Grading(int gradeId, String gradeType, int gradePassingStatus) {
		super();
		this.gradeId = gradeId;
		this.gradeType = gradeType;
		this.gradePassingStatus = gradePassingStatus;
	}

	public Grading(String gradeType, int gradePassingStatus) {
		super();
		this.gradeType = gradeType;
		this.gradePassingStatus = gradePassingStatus;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	public int getGradePassingStatus() {
		return gradePassingStatus;
	}

	public void setGradePassingStatus(int gradePassingStatus) {
		this.gradePassingStatus = gradePassingStatus;
	}

	@Override
	public String toString() {
		return "Grading [gradeId=" + gradeId + ", gradeType=" + gradeType + ", gradePassingStatus=" + gradePassingStatus
				+ "]";
	}
	
	

}
