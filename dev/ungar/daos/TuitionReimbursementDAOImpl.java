package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.TuitionReimbursement;
import dev.ungar.util.JDBCConnection;

public class TuitionReimbursementDAOImpl implements TuitionReimbursementDAO {
	
public static Connection conn = JDBCConnection.getConnection();


	@Override
	public TuitionReimbursement getTuitionReimbursement(int id) {
		try {
			
			String sql = "select * from tuition_reimbursement where tuition_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				TuitionReimbursement tr = new TuitionReimbursement();
				tr.setTuitionId(rs.getInt("TUITION_ID"));
				tr.setEmpId(rs.getInt("EMP_ID"));
				tr.setRemainingTuition(rs.getDouble("REMAINING_TUITION"));
				tr.setPendingReimbursement(rs.getDouble("PENDING_REIMBURSEMENT"));

				return tr;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<TuitionReimbursement> getAllTuitionReimbursements() {
		
		List<TuitionReimbursement> trList = new ArrayList<TuitionReimbursement>();
		
		try {
			
			String sql = "select * from TuitionReimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				TuitionReimbursement tr = new TuitionReimbursement();
				tr.setTuitionId(rs.getInt("TUITION_ID"));
				tr.setEmpId(rs.getInt("EMP_ID"));
				tr.setRemainingTuition(rs.getDouble("REMAINING_TUITION"));
				tr.setPendingReimbursement(rs.getDouble("PENDING_REIMBURSEMENT"));
				
				trList.add(tr);
				return trList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addTuitionReimbursement(TuitionReimbursement tr) {
		try {
			
			String sql = "call add_tr(?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, tr.getEmpId());
			cs.setDouble(3, tr.getRemainingTuition());
			cs.setDouble(4, tr.getPendingReimbursement());
			
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
	public boolean updateTuitionReimbursement(TuitionReimbursement change) {
		try {
			
			String sql = "update tuition_reimbursement set remaining_tuition = ?, set pending_reimbursement = ? where tuition_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, change.getRemainingTuition());
			ps.setDouble(2, change.getPendingReimbursement());
			ps.setInt(3, change.getTuitionId());
			
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
	public boolean updatePending(double amount, int id) {
		System.out.println("update pending");
		System.out.println(amount + " " + id);
		try {
			String sql = "update tuition_reimbursement set pending_reimbursement = ? where tuition_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, amount);
			ps.setDouble(2, id);
			
			ps.executeQuery();
			System.out.println("Updating Pending...successful");
			return true;
		} catch (SQLException e) {
			System.out.println("Updating Pending...failed");
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateApproved(double amount, int id) {
		try {
			
			String sql = "update tuition_reimbursement set remaining_tuition = ?, set pending_reimbursement = ? where tuition_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, amount);
			ps.setDouble(2, 0);
			ps.setInt(3, id);
			
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
	public boolean deleteTuitionReimbursement(int id) {
		try {
			
			String sql = "delete tuition_reimbursement where tuition_id = ?";
			
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
