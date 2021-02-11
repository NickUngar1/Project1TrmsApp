package dev.ungar.services;

import java.util.List;

import dev.ungar.model.Department;

public interface DepartmentService {
	
	public Department getDept(int id);
	public boolean addDept(Department dept);
	public List<Department> getAllDepts();
	public boolean updateDept(Department change);
	public boolean deleteDept(int id);

}
