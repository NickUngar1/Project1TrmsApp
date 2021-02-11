package dev.ungar.services;

import java.util.List;

import dev.ungar.model.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(int id);
	public Employee getEmployee(String email);
	public boolean addEmployee(Employee a);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee change);
	public boolean deleteEmployee(int id);
	
	public Employee login(String email, String password);

}
