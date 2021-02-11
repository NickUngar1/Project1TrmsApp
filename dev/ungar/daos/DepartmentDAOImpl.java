package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.Department;
import dev.ungar.util.JDBCConnection;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	public static Connection conn = JDBCConnection.getConnection();


	@Override
	public Department getDept(int id) {
		try {
			
			String sql = "select * from department where dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Department d= new Department();
				d.setDeptId(rs.getInt("DEPT_ID"));
				d.setDeptName(rs.getString("DEPT_NAME"));
				d.setDeptHead(rs.getInt("DEPT_HEAD_ID"));
				
				return d;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Department> getAllDepts() {
		List<Department> deptList = new ArrayList<Department>();
		
		try {
			
			String sql = "select * from department";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Department d = new Department();
				d.setDeptId(rs.getInt("DEPT_ID"));
				d.setDeptName(rs.getString("DEPT_NAME"));	
				d.setDeptHead(rs.getInt("DEPT_HEAD"));
				
				deptList.add(d);
				return deptList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addDept(Department dept) {
		try {
			
			String sql = "call add_department(?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, dept.getDeptName());
			cs.setInt(2, dept.getDeptHead());
			
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
	public boolean updateDept(Department change) {
		try {
			
			String sql = "update department set dept_name = ?, dept_head = ?  where dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getDeptName());
			ps.setInt(2, change.getDeptHead());
			ps.setInt(3, change.getDeptId());
			
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
	public boolean deleteDept(int id) {
		try {
			
			String sql = "delete department where dept_id = ?";
			
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

}
