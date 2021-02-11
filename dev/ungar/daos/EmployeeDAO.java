package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.Employee;

//static table only needs to be referenced
public interface EmployeeDAO {
	
	public Employee getEmployee(int id);
	public Employee getEmployee(String email);
	public boolean addEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee change);
	public boolean deleteEmployee(int id);
	
	public Employee isValidEmp(String email, String password);

}
