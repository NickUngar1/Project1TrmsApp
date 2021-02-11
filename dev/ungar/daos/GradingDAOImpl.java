package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.Grading;
import dev.ungar.util.JDBCConnection;

public class GradingDAOImpl implements GradingDAO {
	
	public static Connection conn = JDBCConnection.getConnection();


	@Override
	public Grading getGrading(int id) {
		
		try {
			
			String sql = "select * from grading where grade_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Grading g= new Grading();
				g.setGradeId(rs.getInt("GRADE_ID"));
				g.setGradeType(rs.getString("GRADE_TYPE"));
				g.setGradePassingStatus(rs.getInt("GRADE_PASSING_STATUS"));
				
				return g;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<Grading> getAllGrading() {
		List<Grading> gradeList = new ArrayList<Grading>();
		
		try {
			
			String sql = "select * from grading";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Grading g = new Grading();
				g.setGradeId(rs.getInt("GRADE_ID"));
				g.setGradeType(rs.getString("GRADE_TYPE"));	
				g.setGradePassingStatus(rs.getInt("GRADE_PASSING_STATUS"));
				
				gradeList.add(g);
				return gradeList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addGrading(Grading g) {
		try {
			
			String sql = "call add_grading(?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, g.getGradeType());
			cs.setInt(2, g.getGradePassingStatus());
			
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
	public boolean updateGrading(Grading change) {
		try {
			
			String sql = "update grading set grade_type = ?, grade_passing_status = ? where grade_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getGradeType());
			ps.setInt(2, change.getGradePassingStatus());
			ps.setInt(3, change.getGradeId());
			
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
	public boolean deleteGrading(int id) {
		
		try {
			
			String sql = "delete grading where grade_id = ?";
			
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
