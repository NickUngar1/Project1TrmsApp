package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.Approval;
import dev.ungar.util.JDBCConnection;

public class ApprovalDAOImpl implements ApprovalDAO {
	
public static Connection conn = JDBCConnection.getConnection();


	@Override
	public Approval getApproval(int id) {
		try {
			
			String sql = "select * from approval where form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Approval a = new Approval();
				a.setAppId(rs.getInt("APP_ID"));
				a.setFormId(rs.getInt("FORM_ID"));
				a.setSupAppStatus(rs.getInt("SUP_APP_STATUS"));
				a.setDeptAppStatus(rs.getInt("DEPT_APP_STATUS"));
				a.setBenAppStatus(rs.getInt("BEN_APP_STATUS"));

				
				return a;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Approval> getAllApprovals() {
		List<Approval> appList = new ArrayList<Approval>();
		
		try {
			
			String sql = "select * from approval";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Approval a = new Approval();
				a.setAppId(rs.getInt("APP_ID"));
				a.setFormId(rs.getInt("FORM_ID"));
				a.setSupAppStatus(rs.getInt("SUP_APP_STATUS"));
				a.setDeptAppStatus(rs.getInt("DEPT_APP_STATUS"));
				a.setBenAppStatus(rs.getInt("BEN_APP_STATUS"));
				
				appList.add(a);
				return appList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addApproval(Approval a) {
		try {
			
			String sql = "call add_approval(?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getFormId());
			cs.setInt(2, a.getSupAppStatus());
			cs.setInt(3, a.getDeptAppStatus());
			cs.setInt(4, a.getBenAppStatus());

			
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
	public boolean updateApproval(Approval change) {
		try {
			
			String sql = "update approval set sup_app_status = ?, dept_app_status = ?, ben_app_status = ? where app_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, change.getSupAppStatus());
			ps.setInt(2, change.getDeptAppStatus());
			ps.setInt(3, change.getBenAppStatus());
			ps.setInt(4, change.getAppId());
			
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
	public boolean deleteApproval(int id) {
		try {
			
			String sql = "delete approval where app_id = ?";
			
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
