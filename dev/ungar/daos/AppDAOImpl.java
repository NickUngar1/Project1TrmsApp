package dev.ungar.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.ungar.model.Employee;
import dev.ungar.model.Form;
import dev.ungar.util.JDBCConnection;

public class AppDAOImpl implements AppDAO {
	
public static Connection conn = JDBCConnection.getConnection();


	@Override
	public Form getFormsAsSup(int id) {
//		try {
			Form f = new Form();
			f.setFormId(6);
			f.setEmpId(12);
			f.setEventLocation("loc");
			f.setEventDescription("desc");
			f.setEventCost(156);
			f.setEventId(1);
			f.setGradeId(1);
			return f;
////			String sql = "select  e.emp_id, e.dept_id, e.sup_id, "
////					+ "f.emp_id, f.event_location, f.event_description, f.event_cost, f.event_id, f.grade_id, "
////					+ "a.form_id, a.sup_app_status, a.dept_app_status, a.ben_app_status "
////					+ "from employee e, "
////					+ "    form f, "
////					+ "    approval a "
////					+ "where e.sup_id = ? "
////					+ "and f.emp_id = e.emp_id "
////					+ "and a.sup_app_status = 0";
////			String sql = "select emp_id from employee where sup_id = ?";
////			String sql = "select * from form inner join employee on employee.emp_id = form.emp_id \r\n"
////					+ " where employee.sup_id = ?";
//			String sql = "select * from form";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			//ps.setString(1, Integer.toString(id));
//			ResultSet rs = ps.executeQuery();			
//			
//			if(rs.next()) {
//				Form f = new Form();
//				f.setFormId(rs.getInt("FORM_ID"));
//				f.setEmpId(rs.getInt("EMP_ID"));
//				f.setEventLocation(rs.getString("EVENT_LOCATION"));
//				f.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
//				f.setEventCost(rs.getInt("EVENT_COST"));
//				f.setEventId(rs.getInt("EVENT_ID"));
//				f.setGradeId(rs.getInt("GRADE_ID"));
//				System.out.println(f);
//				return f;
//			}
//
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
	}
	
	@Override
	public boolean supUp(int id) {
		try {
			
			String sql = "update approval set sup_app_status = 1 where app_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	public Form getFormsAsDept(int id) {
		return null;
	}

	@Override
	public Form getFormsAsCeo(int id) {
		return null;
	}

}
