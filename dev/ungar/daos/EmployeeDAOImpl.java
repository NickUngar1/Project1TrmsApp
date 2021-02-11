package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.Employee;
import dev.ungar.util.JDBCConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployee(int id) {
		try {
			
			String sql = "select * from employee where emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt("EMP_ID"));
				e.setEmpFname(rs.getString("EMP_FNAME"));
				e.setEmpLname(rs.getString("EMP_LNAME"));
				e.setEmpEmail(rs.getString("EMP_EMAIL"));
				e.setEmpPassword(rs.getString("EMP_PASSWORD"));
				e.setDeptId(rs.getInt("DEPT_ID"));
				e.setSupId(rs.getInt("SUP_ID"));
				
				return e;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public Employee getEmployee(String email) {
		try {
			
			String sql = "select * from employee where emp_email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt("EMP_ID"));
				e.setEmpFname(rs.getString("EMP_FNAME"));
				e.setEmpLname(rs.getString("EMP_LNAME"));
				e.setEmpEmail(rs.getString("EMP_EMAIL"));
				e.setEmpPassword(rs.getString("EMP_PASSWORD"));
				e.setDeptId(rs.getInt("DEPT_ID"));
				e.setSupId(rs.getInt("SUP_ID"));
				
				return e;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			
			String sql = "select * from employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt("EMP_ID"));
				e.setEmpFname(rs.getString("EMP_FNAME"));
				e.setEmpLname(rs.getString("EMP_LNAME"));
				e.setEmpEmail(rs.getString("EMP_EMAIL"));
				e.setEmpPassword(rs.getString("EMP_PASSWORD"));
				e.setDeptId(rs.getInt("DEPT_ID"));
				e.setSupId(rs.getInt("SUP_ID"));
				
				empList.add(e);
				return empList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		try {
			
			String sql = "call add_employee(?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, emp.getEmpFname());
			cs.setString(2, emp.getEmpLname());
			cs.setString(2, emp.getEmpEmail());
			cs.setString(2, emp.getEmpPassword());
			cs.setInt(2, emp.getDeptId());
			cs.setInt(2, emp.getSupId());

			
			cs.execute();
			System.out.println("Creation Successful");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Creation Failed");
		}
		
		return false;
	}

	

	@Override
	public boolean updateEmployee(Employee change) {
		try {
			
			String sql = "update employee set emp_fname = ?, emp_lname = ?, emp_email = ?, set emp_password = ?, set dept_id = ?, set sup_id = ? where emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getEmpFname());
			ps.setString(2, change.getEmpLname());
			ps.setString(3, change.getEmpEmail());
			ps.setString(4, change.getEmpPassword());
			ps.setInt(5, change.getDeptId());
			ps.setInt(6, change.getSupId());
			ps.setInt(7, change.getEmpId());
			
			ps.executeQuery();
			System.out.println("Update successful");
			return true;

			
		} catch (SQLException e) {
			System.out.println("Update failed");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {			
			try {
				
				String sql = "delete employee where emp_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));
				
				ps.executeQuery();
				System.out.println("successfully deleted");
				return true;
				
			} catch (SQLException e) {
				System.out.println("deletion failed");
				e.printStackTrace();
			}
			
			return false;
	}
	
	
	public Employee isValidEmp(String email, String password) {
		try {
			
			String sql = "select * from employee where emp_email = ? and emp_password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt("EMP_ID"));
				e.setEmpFname(rs.getString("EMP_FNAME"));
				e.setEmpLname(rs.getString("EMP_LNAME"));
				e.setEmpEmail(rs.getString("EMP_EMAIL"));
				e.setEmpPassword(rs.getString("EMP_PASSWORD"));
				e.setDeptId(rs.getInt("DEPT_ID"));
				e.setSupId(rs.getInt("SUP_ID"));
				
				return e;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}

