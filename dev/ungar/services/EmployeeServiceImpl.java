package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.EmployeeDAO;
import dev.ungar.daos.EmployeeDAOImpl;
import dev.ungar.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO ed = new EmployeeDAOImpl();

	@Override
	public Employee getEmployee(int id) {
		return ed.getEmployee(id);
	}
	
	@Override
	public Employee getEmployee(String email) {
		return ed.getEmployee(email);
	}

	@Override
	public boolean addEmployee(Employee a) {
		return ed.addEmployee(a);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ed.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(Employee change) {
		return ed.updateEmployee(change);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return ed.deleteEmployee(id);
	}
	
	public Employee login(String email, String password) {
		return ed.isValidEmp(email, password);
	}

}
