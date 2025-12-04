package BusResv;

import java.sql.*;
import java.sql.DriverManager;

public class DbConnection{
	
	private static final String url = "jdbc:mysql://localhost:3306/busresv";
	private static final String userName = "root";
	private static final String password = "root";
	
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	
	
}