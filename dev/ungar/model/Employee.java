package dev.ungar.model;

public class Employee {
	
	int empId;
	String empFname;
	String empLname;
	String empEmail;
	String empPassword;
	int deptId;
	int supId;
	
	//no-args
	public Employee() {
		super();
	}

	//full-args
	public Employee(int empId, String empFname, String empLname, String empEmail, String empPassword, int deptId, int supId) {
		super();
		this.empId = empId;
		this.empFname = empFname;
		this.empLname = empLname;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.deptId = deptId;
		this.supId = supId;
	}

	//id-less
	public Employee(String empFname, String empLname, String empEmail, String empPassword, int deptId, int supId) {
		super();
		this.empFname = empFname;
		this.empLname = empLname;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.deptId = deptId;
		this.supId = supId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpFname() {
		return empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpLname() {
		return empLname;
	}

	public void setEmpLname(String empLname) {
		this.empLname = empLname;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFname=" + empFname + ", empLname=" + empLname + ", empEmail="
				+ empEmail + ", empPassword=" + empPassword + ", deptId=" + deptId + ", supId=" + supId + "]";
	}
	
	
}
