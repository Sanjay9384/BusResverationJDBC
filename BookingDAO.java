package BusResv;

import java.util.Date;
import java.sql.*;

public class BookingDAO{

	public int getBookedCount(int busNo, Date date) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		String query = "Select count(passenger_name) from booking where bus_no = ? and travel_date = ?;";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, busNo);
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		ps.setDate(2, sqlDate);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

		public void add(Booking booking) throws SQLException {
			Connection conn = DbConnection.getConnection();
			String query = "Insert into booking values (?,?,?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, booking.getPassengerName());
			ps.setInt(2, booking.getBusNo());
			java.sql.Date sqlDate = new java.sql.Date(booking.getDate().getTime());
			ps.setDate(3, sqlDate);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				System.out.println("Booking Details Updated :)");
			}

	}
	
}