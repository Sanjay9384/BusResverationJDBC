package BusResv;

import java.sql.*;

public class  BusDAO{

	public void displayBusInfo() throws SQLException {
		
		String query = "Select * from bus";
		Connection conn = DbConnection.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus No: "+rs.getInt(1));
			
			if(rs.getInt(2) == 0) {
				System.out.println("Ac: No");
			}
			else {
				System.out.println("AC: Yes");
			}
		    System.out.println("Capacity: "+rs.getInt(3));
		    
		    System.out.println(" ------------------------------------------------ ");
			}
		}
		
	public int getCapacity(int id) throws SQLException{
		String query  = "Select capacity from bus where id = "+id;
		Connection conn = DbConnection.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		
		return rs.getInt(1);
		
	}
		
	}