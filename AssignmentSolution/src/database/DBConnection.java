package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static  Connection conn = getConnection();
    
	private static Connection getConnection()
    {
       
        // 1. Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/gl2023",
                    "root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static Connection getConn() {
		return conn;
	}

	public static void closeConnection() throws SQLException
    {
    	conn.close();
    }
}
