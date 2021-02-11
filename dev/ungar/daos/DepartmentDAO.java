package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.Department;

//static table only needs to be referenced
public interface DepartmentDAO {
	
	public Department getDept(int id);
	public boolean addDept(Department dept);
	public List<Department> getAllDepts();
	public boolean updateDept(Department change);
	public boolean deleteDept(int id);

}
