package database;

import java.sql.Connection;

public class DBConnection {

    public static Connection getConnection()
    {
        Connection conn = null;
        // 1. Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
