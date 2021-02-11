package dev.ungar.model;

public class Department {
	
	int deptId;
	String deptName;
	int deptHead;
	
	public Department() {
		super();
	}
	
	public Department(int deptId, String deptName, int deptHead) {
		super();
		this.deptId=deptId;
		this.deptName=deptName;
		this.deptHead=deptHead;
	}
	
	public Department(String deptName, int deptHead) {
		super();
		this.deptName=deptName;
		this.deptHead=deptHead;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(int deptHead) {
		this.deptHead = deptHead;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}
	
	

}
