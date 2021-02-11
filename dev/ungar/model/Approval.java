package dev.ungar.model;

public class Approval {
	
	int appId;
	int formId;
	int supAppStatus;
	int deptAppStatus;
	int benAppStatus;
	
	//default no-args
	public Approval() {
		super();
	}

	//full-args
	public Approval(int appId, int formId, int supAppStatus, int deptAppStatus, int benAppStatus) {
		super();
		this.appId = appId;
		this.formId = formId;
		this.supAppStatus = supAppStatus;
		this.deptAppStatus = deptAppStatus;
		this.benAppStatus = benAppStatus;
	}
	
	//id-less
	public Approval(int formId, int supAppStatus, int deptAppStatus, int benAppStatus) {
		super();
		this.formId = formId;
		this.supAppStatus = supAppStatus;
		this.deptAppStatus = deptAppStatus;
		this.benAppStatus = benAppStatus;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getSupAppStatus() {
		return supAppStatus;
	}

	public void setSupAppStatus(int supAppStatus) {
		this.supAppStatus = supAppStatus;
	}

	public int getDeptAppStatus() {
		return deptAppStatus;
	}

	public void setDeptAppStatus(int deptAppStatus) {
		this.deptAppStatus = deptAppStatus;
	}

	public int getBenAppStatus() {
		return benAppStatus;
	}

	public void setBenAppStatus(int benAppStatus) {
		this.benAppStatus = benAppStatus;
	}

	@Override
	public String toString() {
		return "Approval [appId=" + appId + ", formId=" + formId + ", supAppStatus=" + supAppStatus + ", deptAppStatus="
				+ deptAppStatus + ", benAppStatus=" + benAppStatus + "]";
	}
	
	

}
