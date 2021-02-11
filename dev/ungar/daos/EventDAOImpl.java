package dev.ungar.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ungar.model.Event;
import dev.ungar.util.JDBCConnection;

public class EventDAOImpl implements EventDAO {
	
	public static Connection conn = JDBCConnection.getConnection();


	@Override
	public Event getEvent(int id) {
		try {
			
			String sql = "select * from event where event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Event ev = new Event();
				ev.setEventId(rs.getInt("EVENT_ID"));
				ev.setEventType(rs.getString("EVENT_TYPE"));
				ev.setEventCoverage(rs.getInt("EVENT_COVERAGE"));
				
				return ev;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<Event> getAllEvents() {
		List<Event> eventList = new ArrayList<Event>();
		
		try {
			
			String sql = "select * from event";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Event ev = new Event();
				ev.setEventId(rs.getInt("EVENT_ID"));
				ev.setEventType(rs.getString("EVENT_TYPE"));
				ev.setEventCoverage(rs.getInt("EVENT_COVERAGE"));
				
				eventList.add(ev);
				return eventList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public boolean addEvent(Event ev) {
		try {
			
			String sql = "call add_event(?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, ev.getEventType());
			cs.setInt(2, ev.getEventCoverage());
			
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
	public boolean updateEvent(Event change) {
		try {
			
			String sql = "update event set event_type = ?, event_coverage = ? where event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getEventType());
			ps.setInt(2, change.getEventCoverage());
			ps.setInt(3, change.getEventId());
			
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
	public boolean deleteEvent(int id) {
		try {
			
			String sql = "delete event where event_id = ?";
			
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
