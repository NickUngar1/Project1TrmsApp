package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.DepartmentDAO;
import dev.ungar.daos.DepartmentDAOImpl;
import dev.ungar.model.Department;

public class DepartmentServiceImpl implements DepartmentService {
	
	DepartmentDAO dd = new DepartmentDAOImpl();

	@Override
	public Department getDept(int id) {
		return dd.getDept(id);
	}

	@Override
	public boolean addDept(Department dept) {
		return dd.addDept(dept);
	}

	@Override
	public List<Department> getAllDepts() {
		return dd.getAllDepts();
	}

	@Override
	public boolean updateDept(Department change) {
		return dd.updateDept(change);
	}

	@Override
	public boolean deleteDept(int id) {
		return dd.deleteDept(id);
	}

}
