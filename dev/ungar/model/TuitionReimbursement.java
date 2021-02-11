package dev.ungar.model;

public class TuitionReimbursement {
	
	int tuitionId;
	int empId;
	double remainingTuition;
	double pendingReimbursement;
	
	public TuitionReimbursement() {
		super();
	}

	public TuitionReimbursement(int tuitionId, int empId, double remainingTuition,
			double pendingReimbursement) {
		super();
		this.tuitionId = tuitionId;
		this.empId = empId;
		this.remainingTuition = remainingTuition;
		this.pendingReimbursement = pendingReimbursement;
	}

	public TuitionReimbursement(int empId, double remainingTuition,
			double pendingReimbursement) {
		super();
		this.empId = empId;
		this.remainingTuition = remainingTuition;
		this.pendingReimbursement = pendingReimbursement;
	}

	public int getTuitionId() {
		return tuitionId;
	}

	public void setTuitionId(int tuitionId) {
		this.tuitionId = tuitionId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getRemainingTuition() {
		return remainingTuition;
	}

	public void setRemainingTuition(double remainingTuition) {
		this.remainingTuition = remainingTuition;
	}

	public double getPendingReimbursement() {
		return pendingReimbursement;
	}

	public void setPendingReimbursement(double pendingReimbursement) {
		this.pendingReimbursement = pendingReimbursement;
	}


	@Override
	public String toString() {
		return "TuitionReimbursement [tuitionId=" + tuitionId + ", empId=" + empId + ", remainingTuition=" + remainingTuition
				+ ", pendingReimbursement=" + pendingReimbursement + "]";
	}
	
	

}
