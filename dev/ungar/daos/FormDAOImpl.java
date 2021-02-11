package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.Form;
import dev.ungar.util.JDBCConnection;

public class FormDAOImpl implements FormDAO {
	
public static Connection conn = JDBCConnection.getConnection();


	@Override
	public Form getForm(int id) {
		try {
			
			String sql = "select * from form where form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Form f = new Form();
				f.setFormId(rs.getInt("FORM_ID"));
				f.setEmpId(rs.getInt("EMP_ID"));
				f.setEventLocation(rs.getString("EVENT_LOCATION"));
				f.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
				f.setEventCost(rs.getInt("EVENT_COST"));
				f.setEventId(rs.getInt("EVENT_ID"));
				f.setGradeId(rs.getInt("GRADE_ID"));
				
				return f;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Form getFormByEmpId(int id) {
		try {
			
			String sql = "select * from form where emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Form f = new Form();
				f.setFormId(rs.getInt("FORM_ID"));
				f.setEmpId(rs.getInt("EMP_ID"));
				f.setEventLocation(rs.getString("EVENT_LOCATION"));
				f.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
				f.setEventCost(rs.getInt("EVENT_COST"));
				f.setEventId(rs.getInt("EVENT_ID"));
				f.setGradeId(rs.getInt("GRADE_ID"));
				
				return f;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<Form> getAllForms() {
		List<Form> formList = new ArrayList<Form>();
			
			try {
				
				String sql = "select * from form";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Form f = new Form();
					f.setFormId(rs.getInt("FORM_ID"));
					f.setEmpId(rs.getInt("GRADE_TYPE"));
					f.setEventLocation(rs.getString("EVENT_LOCATION"));
					f.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
					f.setEventCost(rs.getInt("EVENT_COST"));
					f.setEventId(rs.getInt("EVENT_ID"));
					f.setGradeId(rs.getInt("GRADE_ID"));
					
					formList.add(f);
					return formList;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public boolean addForm(Form f) {
		
		try {
			
			String sql = "call add_form(?, ?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, f.getEmpId());
			cs.setString(2, f.getEventLocation());
			cs.setString(3, f.getEventDescription());
			cs.setDouble(4, f.getEventCost());
			cs.setInt(5, f.getEventId());
			cs.setInt(6, f.getGradeId());

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
	public boolean updateForm(Form change) {
		try {
			
			String sql = "update tuition_reimbursement set grade_id = ? where form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, change.getGradeId());
			ps.setInt(2, change.getFormId());
			
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
	public boolean deleteForm(int id) {
		try {
			
			String sql = "delete form where form_id = ?";
			
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
	
	@Override
	public boolean supUp(int id) {
		try {
			
			String sql = "update approval set sup_app_status = 1 where app_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setInt(1, id);
			
			ps.executeQuery();
			System.out.println("Update successful");
			System.out.println(sql);
			return true;

			
		} catch (SQLException e) {
			System.out.println("Update failed");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean ceoUp(int id) {
		try {
			
			String sql = "update approval set ben_app_status = 1 where app_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setInt(1, id);
			
			ps.executeQuery();
			System.out.println("Update successful");
			System.out.println(sql);
			return true;

			
		} catch (SQLException e) {
			System.out.println("Update failed");
			e.printStackTrace();
		}
		return false;
	}
	public Form ceoGet(int id) {
		try {
			
			String sql = "select * from form where form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Form f = new Form();
				f.setFormId(rs.getInt("FORM_ID"));
				f.setEmpId(rs.getInt("EMP_ID"));
				f.setEventLocation(rs.getString("EVENT_LOCATION"));
				f.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
				f.setEventCost(rs.getInt("EVENT_COST"));
				f.setEventId(rs.getInt("EVENT_ID"));
				f.setGradeId(rs.getInt("GRADE_ID"));
				
				return f;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean updateApproved(double amount, int id) {
		try {
			
			String sql = "update tuition_reimbursement set remaining_tuition = ? where tuition_id = 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, amount);
			//ps.setInt(2, id);
			
			ps.executeQuery();
			System.out.println("Update approved successful");

			
		} catch (SQLException e) {
			System.out.println("Update approved failed");
			e.printStackTrace();
		}
		try {
			
			String sql = "update tuition_reimbursement set pending_reimbursement = 0 where tuition_id = 5";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			
			//ps.setDouble(1, amount);
			//ps.setInt(2, id);
			
			ps2.executeQuery();
			System.out.println("Update approved successful");
			return true;

			
		} catch (SQLException e) {
			System.out.println("Update approved failed");
			e.printStackTrace();
		}
		return false;
	}


}
